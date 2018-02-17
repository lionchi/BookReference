package ru.gavrilov.core.exeptions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gavrilov.core.abstracts.Guard;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class IllegalOperationExceptionData {
    private final String error;
    private final String message;

    @JsonCreator
    public IllegalOperationExceptionData(
            @Nonnull @JsonProperty("error") String error,
            @Nullable @JsonProperty("message") String message) {
        Guard.notEmpty(error, "Error must not be empty");
        this.error = error;
        this.message = message;
    }

    @Nonnull
    public String getError() {
        return error;
    }

    @Nullable
    public String getMessage() {
        return message;
    }
}
