# PagerDuty 🔧🚨 (Backend Engineer Showcase Project)

A distributed microservices system inspired by **PagerDuty**, built to demonstrate real-world backend engineering skills: centralized logging, alert deduplication, Kafka-based notifications, AI-assisted diagnostics, and secure authentication.

---

## 🧩 Microservices Overview

### 1. Logger Service 📜

- Logs failure events from other services.
- Detects duplicate errors in a short interval using Redis.
- Publishes alerts to Kafka.

### 2. Notification Service 🔔

- Kafka subscriber.
- Notifies users/admins of critical issues via email/logs.
- Pluggable notification mechanism (Slack/email/webhook-ready).

### 3. AI Wrapper Service 🤖

- Integrates with an open-source or free-tier LLM (like `gpt2`, `llama2`, or Ollama).
- Suggests possible resolutions based on the failure log.
- Can classify or summarize logs.

### 4. IAM Service 🔐

- Handles login and authentication with JWT.
- Stores user data and roles (admin/dev).
- Enables secure access to logs, dashboards, and settings.

### 5. Dashboard Service 📊 (Optional)

- A web frontend to view logs, alerts, suggestions, and statistics.
- Real-time insights via polling or WebSocket.
- Built with React or Spring Boot (your choice).

---

## 🛠 Tech Stack

| Layer               | Tech                           |
| ------------------- | ------------------------------ |
| Backend             | Java + Spring Boot             |
| Messaging           | Kafka                          |
| Cache               | Redis                          |
| DB                  | PostgreSQL                     |
| Auth                | JWT                            |
| AI                  | HuggingFace, Ollama, Replicate |
| Deployment          | Docker, Docker Compose         |
| Monitoring (Future) | Prometheus + Grafana           |

---

## 📦 Getting Started

### Clone and Run

```bash
git clone https://github.com/your-username/pagerduty.git
cd pagerduty
docker-compose up --build
```
