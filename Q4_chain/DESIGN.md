
# Q4 — Chain of Responsibility
- **Padrão:** Chain com condicionais, *circuit breaker* (3 falhas), *rollback* (validador 4) e *timeout* individual.
- **Regras:** Validadores 3 (Regras Fiscais) e 5 (SEFAZ) **só** rodam se anteriores passarem.
- **Rollback:** `ValidadorBancoDados` insere/flag e reverte caso alguém depois falhe.
