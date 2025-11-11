
# Avaliação Prática — SOLID + Design Patterns (Java)

Estrutura:
- `Q1_strategy/` — algoritmos de risco intercambiáveis (Strategy).
- `Q2_adapter/` — integração moderno ↔ legado (Adapter bidirecional).
- `Q3_state/` — controle de estados da usina (State) + modo manutenção.
- `Q4_chain/` — validação NF-e (Chain of Responsibility) + condicionais + circuit breaker + rollback + timeout.

## Como compilar (Java 17+)
```bash
# Q1
javac Q1_strategy/*.java && java -cp . Q1_strategy.Q1Main

# Q2
javac Q2_adapter/*.java && java -cp . Q2_adapter.Q2Main

# Q3
javac Q3_state/*.java && java -cp . Q3_state.Q3Main

# Q4
javac Q4_chain/*.java && java -cp . Q4_chain.Q4Main
```