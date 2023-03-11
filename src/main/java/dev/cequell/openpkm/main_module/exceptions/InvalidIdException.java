package dev.cequell.openpkm.main_module.exceptions;

import io.smallrye.graphql.api.ErrorCode;

import java.util.UUID;

@ErrorCode("invalid-id")
public class InvalidIdException extends RuntimeException {
    public InvalidIdException(final UUID id) {
        super("Id '%s' not found".formatted(id.toString()));
    }
}
