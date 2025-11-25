# Desafio de Modelagem de Domínio em Kotlin: Sistema DIO Formações

Este projeto foi desenvolvido como um desafio prático de Programação Orientada a Objetos (POO) em Kotlin para simular um sistema simplificado de gestão de **Formações** e **Matrículas de Alunos**.

O código aplica e demonstra conceitos fundamentais e avançados da linguagem Kotlin, focando em segurança, concisão e arquitetura idiomática.

## 💡 Conceitos de Kotlin Aplicados

O projeto foi construído usando as seguintes funcionalidades e melhores práticas do Kotlin, que definem a solução:

| Conceito | Aplicação no Projeto |
| :--- | :--- |
| **POO Idiomático** | Uso de **`data class`** para as entidades `Aluno`, `ConteudoEducacional` e `Formacao`, garantindo métodos utilitários automáticos (`toString`, `equals`). |
| **Coleções Mutáveis** | Uso de **`mutableListOf<Aluno>()`** para gerenciar a lista de inscritos em cada `Formacao`. |
| **Tratamento de Exceções** | Utilização de `throw IllegalArgumentException` dentro do método `matricular()` para impedir e sinalizar erros de matrícula duplicada. |
| **Extensão de Função** | Criação de `fun Formacao.duracaoTotal()`, adicionando funcionalidade à classe `Formacao` de forma externa e limpa. |
| **Funções de Alta Ordem** | Uso de **`.sumOf { ... }`** para calcular a duração total da Formação e **`.forEach { ... }`** para iteração na lista de inscritos. |
| **Enum** | Definição do `enum class Nivel` para padronizar e tipificar a dificuldade das formações e conteúdos. |

## 📋 Entidades Modeladas

O domínio foi modelado com as seguintes classes:

### 1. `data class Aluno`

Representa o usuário matriculado. Possui atributos imutáveis (`id`, `nome`) e mutáveis (`idade`, `matriculado`), além do suporte a valores nulos (`Int?` para `idade`).

### 2. `data class ConteudoEducacional`

Define os módulos da formação, com nome, duração (`Int`) e seu respectivo `Nivel` de dificuldade.

### 3. `data class Formacao`

A entidade central que agrega uma lista de `ConteudoEducacional`, um `Nivel` geral e o estado de seus alunos matriculados (`inscritos`).

## ⚙️ Lógica Implementada

O projeto simula a matrícula com as seguintes regras:

1.  **Matrícula:** A função `matricular(aluno: Aluno)` adiciona um aluno à lista `inscritos` da `Formacao`.
2.  **Validação de Duplicidade:** O método usa `inscritos.contains(aluno)` para garantir que o aluno não seja matriculado duas vezes.
3.  **Controle de Erros:** Em caso de tentativa de matrícula duplicada, o sistema lança uma `IllegalArgumentException`, que é tratada no `main()` por um bloco `try-catch`.
4.  **Cálculo da Duração:** A Extension Function `duracaoTotal()` retorna a soma das durações de todos os conteúdos da formação.

## 🧪 Como Executar

O projeto é um programa de console Kotlin e pode ser executado diretamente em qualquer IDE (como IntelliJ IDEA ou Android Studio) que suporte o Kotlin:

1.  Crie um novo **Kotlin Console Application** (ou `Kotlin File`).
2.  Cole todo o código.
3.  Execute a função `main()` para rodar os cenários de teste.

O bloco `main()` demonstra a criação de objetos e o teste da lógica de exceção (tentativa de matrícula duplicada) e do cálculo da duração total.