
# Q2 — Adapter Bidirecional
- **Padrão:** Adapter (Modern ↔ Legacy).
- **Regras:** mapear moeda (USD=1, EUR=2, BRL=3); incluir campo obrigatório do legado (ex.: `canal`).
- **SOLID:** SRP (cada adapter traduz um protocolo), DIP (código cliente depende de interfaces).
