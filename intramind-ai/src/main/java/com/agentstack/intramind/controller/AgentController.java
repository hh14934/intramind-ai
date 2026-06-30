package com.agentstack.intramind.controller;

import com.agentstack.intramind.agent.AgentService;
import com.agentstack.intramind.dto.AgentRequest;
import com.agentstack.intramind.dto.AgentResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agent")
public class AgentController {
    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/ask")
    public AgentResponse ask(@RequestBody AgentRequest request) {
        return agentService.ask(request);
    }
}
