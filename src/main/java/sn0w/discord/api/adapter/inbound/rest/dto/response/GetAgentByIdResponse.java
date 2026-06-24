package sn0w.discord.api.adapter.inbound.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAgentByIdResponse {
    private String agentId;
    private String agentName;
    private String agentType;
    private String haveMolly;
    private String haveFlash;
    private String agentStatus;
    private String creationDate;
}
