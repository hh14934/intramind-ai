package com.agentstack.intramind.tools;

import com.agentstack.intramind.rag.KnowledgeBaseService;
import com.agentstack.intramind.tenant.TenantContext;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class DomainTools {
    private final KnowledgeBaseService knowledgeBaseService;

    public DomainTools(KnowledgeBaseService knowledgeBaseService) {
        this.knowledgeBaseService = knowledgeBaseService;
    }

    @Tool(description = "Search tenant scoped private knowledge base")
    public String knowledge_search(@ToolParam(description = "search query") String query) {
        return String.join("\n", knowledgeBaseService.search(query));
    }

    @Tool(description = "feishu doc search for 智能客服与问答")
    public String feishu_doc_search(@ToolParam(description = "business query") String query) {
        return "[feishu_doc_search] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

    @Tool(description = "yuque page fetch for 智能客服与问答")
    public String yuque_page_fetch(@ToolParam(description = "business query") String query) {
        return "[yuque_page_fetch] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

    @Tool(description = "oss policy doc loader for 智能客服与问答")
    public String oss_policy_doc_loader(@ToolParam(description = "business query") String query) {
        return "[oss_policy_doc_loader] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

    @Tool(description = "hr policy lookup for 智能客服与问答")
    public String hr_policy_lookup(@ToolParam(description = "business query") String query) {
        return "[hr_policy_lookup] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

    @Tool(description = "workflow router for 智能客服与问答")
    public String workflow_router(@ToolParam(description = "business query") String query) {
        return "[workflow_router] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

    @Tool(description = "ticket suggestion for 智能客服与问答")
    public String ticket_suggestion(@ToolParam(description = "business query") String query) {
        return "[ticket_suggestion] tenant=" + TenantContext.getTenantId() + "; result for: " + query + "; demo stub, connect real system in production.";
    }

}
