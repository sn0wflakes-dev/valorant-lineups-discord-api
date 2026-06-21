package sn0w.discord.api.adapter.inbound.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddAgentResponse {
    private String message;
    private String id;
    private String name;
}
