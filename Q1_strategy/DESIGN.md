
# Q1 — Strategy
- **Padrão:** Strategy para alternar algoritmos em runtime.
- **SOLID:** SRP (cada algoritmo calcula UMA métrica), OCP (novos algoritmos sem tocar no resto), DIP (cliente depende da interface `RiskAlgorithm`).
- **Decisões:** Contexto financeiro reunido em `RiskContext` para evitar acoplamento com fontes externas e facilitar teste.
