# IntraMind AI Community

        企业制度流程智能客服 Agent：基于 **Spring AI 2.0 + Agent Tool Calling + PGVector RAG + Ollama** 的智能客服与问答项目模板。


        ## 场景定位

        接入飞书、语雀、云 OSS、制度流程文档，让 Agent 精准解答员工关于制度、流程、报销、请假、采购、权限申请等问题。

        ## 版本定位：开源版


- 单租户或轻量租户 Header 演示
- 本地 Ollama 模型，适合开发和 Demo
- 基础 RAG 知识库、基础工具调用、REST API
- Apache-2.0 友好的开源项目结构
- 可作为 Open Core 的免费获客漏斗

        ## 核心能力

        - Spring AI `ChatClient` Agent 编排
        - `@Tool` 工具调用
        - PGVector 私有知识库 RAG
        - Ollama 本地模型默认配置
        - Docker Compose 一键启动基础设施
        - Flyway 数据库初始化
        - Prometheus / Actuator 可观测性

        ## 工具清单

        - `feishu_doc_search`
- `yuque_page_fetch`
- `oss_policy_doc_loader`
- `hr_policy_lookup`
- `workflow_router`
- `ticket_suggestion`

        ## 连接器方向

        - Feishu/Lark Docs
- Yuque
- Aliyun OSS / MinIO
- 企业工单系统

        ## API

        | Method | Path | Description |
        |---|---|---|
        | POST | `/api/agent/ask` | 员工制度/流程问答 |
| POST | `/api/kb/sync` | 同步飞书/语雀/OSS 知识库 |
| GET | `/api/tickets/suggest` | 根据问题推荐工单流转 |
        | POST | `/api/kb/sync` | 同步知识库 |
        | GET | `/api/kb/search?q=` | 检索知识库 |

        ## 本地运行

        ```bash
        cp .env.example .env
        docker compose up -d
        ollama pull qwen2.5:7b
        ollama pull mxbai-embed-large
        mvn spring-boot:run
        ```

        ## 示例调用

        ```bash
        curl -s -X POST http://localhost:8080/api/agent/ask \
          -H 'Content-Type: application/json' \
          -H 'X-Tenant-Id: demo' \
          -d '{
            "question": "报销差旅费需要哪些材料？超过 30 天还能报销吗？",
            "userId": "u_1001",
            "sessionId": "s_demo"
          }' | jq
        ```

        ## 目录结构

        ```text
        src/main/java/.../agent        Agent 编排
        src/main/java/.../tools        工具调用
        src/main/java/.../rag          RAG 服务
        src/main/java/.../tenant       多租户上下文
        src/main/resources/kb          示例知识库
        src/main/resources/db          Flyway 初始化 SQL
        docs/                          架构、API、部署、定价、演示脚本
        ```

        ## GitHub 上传

        ```bash
        git init
        git add .
        git commit -m "Initial commit: IntraMind AI Community"
        gh repo create intramind-ai --public --source=. --remote=origin --push
        ```
