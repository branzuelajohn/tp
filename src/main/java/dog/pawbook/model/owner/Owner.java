package dog.pawbook.model.owner;

import static dog.pawbook.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import dog.pawbook.model.Identifiable;
import dog.pawbook.model.tag.Tag;

/**
 * Represents a Owner in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Owner {


    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;
    private int userID;
    private static int userIDCounter =  0;
    // Data fields
    private final Address address;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Owner(Name name, Phone phone, Email email, Address address, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, address, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        userIDCounter++;
        this.userID = userIDCounter;
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public int getID() {
        return userID;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both owners have the same name.
     * This defines a weaker notion of equality between two owners.
     */
    public boolean isSameOwner(Owner otherOwner) {
        if (otherOwner == this) {
            return true;
        }

        return otherOwner != null
                && otherOwner.getName().equals(getName());
    }

    /**
     * Returns true if both owners have the same identity and data fields.
     * This defines a stronger notion of equality between two owners.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Owner)) {
            return false;
        }

        Owner otherOwner = (Owner) other;
        return otherOwner.getName().equals(getName())
                && otherOwner.getPhone().equals(getPhone())
                && otherOwner.getEmail().equals(getEmail())
                && otherOwner.getAddress().equals(getAddress())
                && String.valueOf(otherOwner.getID()).equals(String.valueOf(getID()))
                && otherOwner.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Phone: ")
                .append(getPhone())
                .append("; Email: ")
                .append(getEmail())
                .append("; Address: ")
                .append(getAddress())
                .append("; ID: ")
                .append(getID());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }

   /* @Override
    public boolean isSameAs(Owner other) {
        if (other == this) {
            return true;
        }

        return other != null
            && (other.getPhone().equals(getPhone())
            || other.getEmail().equals(getEmail())
            || other.getAddress().equals(getAddress()));
    }*/

}
