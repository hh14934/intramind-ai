package com.agentstack.intramind.agent;

import com.agentstack.intramind.dto.AgentRequest;
import com.agentstack.intramind.dto.AgentResponse;
import com.agentstack.intramind.tools.DomainTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AgentService {
    private final ChatClient chatClient;
    private final DomainTools domainTools;

    public AgentService(ChatClient chatClient, DomainTools domainTools) {
        this.chatClient = chatClient;
        this.domainTools = domainTools;
    }

    public AgentResponse ask(AgentRequest request) {
        String prompt = """
                场景：智能客服与问答
                用户问题：%s

                请按以下格式回答：
                1. 结论
                2. 依据/引用
                3. 需要调用或已经调用的工具
                4. 风险提示
                5. 下一步建议
                """.formatted(request.question());

        String answer = chatClient.prompt()
                .user(prompt)
                .tools(domainTools)
                .call()
                .content();

        return new AgentResponse(
                answer,
                List.of("kb://demo/sample"),
                List.of("feishu_doc_search", "yuque_page_fetch", "oss_policy_doc_loader", "hr_policy_lookup", "workflow_router", "ticket_suggestion"),
                "medium",
                UUID.randomUUID().toString()
        );
    }
}
