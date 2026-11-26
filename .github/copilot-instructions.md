# Project rules for Copilot

Project: DisputeDesk AI – an AI agent that triages bank dispute complaints.
Structure: /backend/disputedesk = Spring Boot (Java 21, Maven), /frontend = Node.js Express.

## Backend rules
- Package: com.bijila.disputedesk
- Layers: controller → service → repository. No business logic in controllers.
- Use Java records for DTOs. Use Spring AI ChatClient for all LLM calls.
- Store prompts as .st files in src/main/resources/prompts/, never as Java strings.
- Never hardcode secrets. Read them from environment variables.
- Every service class gets a JUnit 5 test.
- Keep code simple and readable. No extra libraries unless I ask.

## How to work with me
- Do one step at a time. Explain briefly what you changed and why.
- If something is unclear, ask me before guessing.