# 🏺 Tartarus

**Tartarus** é uma biblioteca de utilitários de baixo nível focada em main.libs.estruturas de dados eficientes, manipulação de strings, gerenciamento de main.libs.tempo e sistemas de entrada/saída (I/O). O projeto prioriza performance e tipagem genérica para facilitar o desenvolvimento de aplicações modulares.

Desenvolvido em colaboração por [@luandkg](https://github.com/luandkg) e [@CalebeAF02](https://github.com/CalebeAF02).

---

## 🛠️ Funcionalidades Principais

### 📦 Estruturas de Dados e Lógica
* **Lista Genérica:** Implementação robusta com suporte a tipos genéricos.
    * Operações: Adicionar/Remover (por valor, posição ou referência), clonagem, limpeza e verificação de vacuidade.
    * **Iteradores:** Suporte a padrões de iteração em `Lista` e `Caixa`.
* **Filtragem:** Classes para condicionais parametrizados e filtros de tipos específicos (ex: Inteiros).

### 📝 Manipulação de Texto
* Funções para busca e comparação (`startsWith`, `endsWith`).
* Transformação de strings (Maiúsculas/Minúsculas).
* Divisão de strings por delimitadores, símbolos ou linhas.
* Utilitários para leitura e escrita de dados textuais.

### ⏱️ Tempo, Datas e Cronometria
* **Cronômetro:** Medição de main.libs.tempo precisa com formatação personalizada (`toString`).
* **Data e Horário:** Gerenciamento de calendários, horários e enums para meses e dias da semana.
* **Formatadores:** Funções dedicadas para formatação de dados temporais.

### 💾 Entrada e Saída (I/O)
* Persistência de dados: Classes especializadas para armazenar e recuperar main.libs.estruturas de `Lista` em arquivos.

### 🧪 Framework de Testes
* **TesteExecutor:** Uma biblioteca interna de testes automatizados criada para garantir a integridade de todas as funções do projeto.

---

## 🚀 Como Utilizar

### Pré-requisitos
* Java JDK (Versão 17 ou superior recomendada) ou compilador compatível com o código fonte.
* Git para clonagem.

### Instalação
1. Clone o repositório:
   ```bash
   git clone [https://github.com/luandkg/tartarus.git](https://github.com/luandkg/tartarus.git)


## 🤝 Contribuidores

| Integrante | Papel | GitHub |
| :--- | :--- | :--- |
| **Luan DKG** | Core, Framework de Testes | [@luandkg](https://github.com/luandkg) |
| **Calebe AF** | Estruturas, Texto e Utilidades | [@CalebeAF02](https://github.com/CalebeAF02) |