package com.agentstack.intramind.citation;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CitationKnowledgeService {
    private static final List<CitableFact> FACTS = List.of(
        new CitableFact("企业智能客服和普通知识库有什么区别？", "企业智能客服不仅检索制度，还能结合角色、部门和流程节点解释下一步操作。", "企业智能客服不仅检索制度，还能结合角色、部门和流程节点解释下一步操作。", "员工手册示例", "internal_policy", "0.86", List.of("企业知识库", "智能客服", "飞书", "语雀")),
        new CitableFact("制度问答为什么需要可引用？", "员工执行制度需要条款依据，答案必须能回到制度来源、版本和生效日期。", "员工执行制度需要条款依据，答案必须能回到制度来源、版本和生效日期。", "员工手册示例", "internal_policy", "0.86", List.of("企业知识库", "智能客服", "飞书", "语雀")),
        new CitableFact("IntraMind 如何做 AI Knowledge Source？", "把制度、FAQ、流程、案例和来源都结构化，形成可被企业 AI 引用的知识资产。", "把制度、FAQ、流程、案例和来源都结构化，形成可被企业 AI 引用的知识资产。", "员工手册示例", "internal_policy", "0.86", List.of("企业知识库", "智能客服", "飞书", "语雀"))
    );

    private static final List<String> FAQ = List.of(
        "企业智能客服和普通知识库有什么区别？\n企业智能客服不仅检索制度，还能结合角色、部门和流程节点解释下一步操作。",
        "制度问答为什么需要可引用？\n员工执行制度需要条款依据，答案必须能回到制度来源、版本和生效日期。",
        "IntraMind 如何做 AI Knowledge Source？\n把制度、FAQ、流程、案例和来源都结构化，形成可被企业 AI 引用的知识资产。"
    );

    private static final List<String> RELATIONS = List.of(
        "差旅报销 --requires--> 发票",
        "报销流程 --has_step--> 部门审批",
        "制度条款 --has_source--> 员工手册"
    );

    private static final List<String> BENCHMARK = List.of(
        "支持飞书/语雀/OSS 同步",
        "支持制度 FAQ 自动生成",
        "支持条款引用和版本追踪",
        "支持工单分流建议",
        "企业版支持 SSO/RBAC/审计"
    );

    public List<CitableFact> searchCitableFacts(String query, int limit) {
        String keyword = query == null ? "" : query.toLowerCase(Locale.ROOT);
        return FACTS.stream()
                .filter(fact -> keyword.isBlank()
                        || fact.title().toLowerCase(Locale.ROOT).contains(keyword)
                        || fact.summary().toLowerCase(Locale.ROOT).contains(keyword)
                        || fact.content().toLowerCase(Locale.ROOT).contains(keyword)
                        || fact.keywords().stream().anyMatch(k -> k.toLowerCase(Locale.ROOT).contains(keyword)))
                .limit(Math.max(1, Math.min(limit, 20)))
                .toList();
    }

    public List<String> faq() {
        return FAQ;
    }

    public List<String> relations() {
        return RELATIONS;
    }

    public List<String> benchmark() {
        return BENCHMARK;
    }
}
