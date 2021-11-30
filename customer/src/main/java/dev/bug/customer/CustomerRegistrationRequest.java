package dev.bug.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
