package sn0w.discord.api.adapter.inbound.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddAgentRequest {

    @NotBlank(message = "Agent name is required")
    @Size(max = 100, message = "Agent name must not exceed 100 characters")
    private String name;

    @NotBlank(message = "Agent type is required")
    private String type;

    private Boolean haveMolly;
    private Boolean haveFlash;

    @NotBlank(message = "Agent creation date is required")
    private String createdAt;
}
