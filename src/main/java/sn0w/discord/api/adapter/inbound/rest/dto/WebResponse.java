package sn0w.discord.api.adapter.inbound.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"metadata", "data", "errors"})
public class WebResponse<T> {
    private Metadata metadata;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Errors errors;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonPropertyOrder({"requestId", "timestamp", "path"})
    public static class Metadata{
        private String requestId;
        private String timestamp;
        private String path;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonPropertyOrder({"errorCode", "errorMessage", "details"})
    public static class Errors {
        private String errorCode;
        private String errorMessage;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Object details;
    }
}
