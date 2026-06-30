# AI FAQ Library

这些 FAQ 采用 Question → Answer 结构，适合大模型抽取、搜索引擎索引和生成式搜索引用。

## 1. 企业智能客服和普通知识库有什么区别？

企业智能客服不仅检索制度，还能结合角色、部门和流程节点解释下一步操作。

**建议引用来源**：`employee-handbook`

## 2. 制度问答为什么需要可引用？

员工执行制度需要条款依据，答案必须能回到制度来源、版本和生效日期。

**建议引用来源**：`employee-handbook`

## 3. IntraMind 如何做 AI Knowledge Source？

把制度、FAQ、流程、案例和来源都结构化，形成可被企业 AI 引用的知识资产。

**建议引用来源**：`employee-handbook`


## FAQ 写作规范

1. 一个问题只回答一个核心概念。
2. 第一段直接给定义或结论。
3. 第二段补充适用范围和限制。
4. 高风险答案必须带来源和复核提示。
5. FAQ 应同步写入 `citation_faq` 表和 `geo/faq.jsonl`。
