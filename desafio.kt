enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

data class Aluno(val id: Int, val nome: String, var idade: Int?, var matriculado: Boolean = false)

data class ConteudoEducacional(var nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Aluno>()

    fun matricular(aluno: Aluno) {
        if (inscritos.contains(aluno)) {
            throw IllegalArgumentException("O Aluno ${aluno.nome} já está matriculado nesta formação.")

        } else {
            inscritos.add(aluno)
            println("Aluno ${aluno.nome} matriculado com sucesso na formação ${this.nome}!")
        }
    }
}

fun Formacao.duracaoTotal(): Int {
    return conteudos.sumOf { it.duracao }
}

fun main() {
    //Criando Conteúdos Educacionais
    val kotlinBasico = ConteudoEducacional("Kotlin Básico", 120, Nivel.BASICO)
    val coroutines = ConteudoEducacional("Coroutines Avançadas", 180, Nivel.AVANÇADO)
    val projetoKotlin = ConteudoEducacional("Projeto Prático Kotlin", 60, Nivel.INTERMEDIARIO)

    //Crian do Formações
    val formacaoKotlin = Formacao("Especialista Kotlin", Nivel.AVANÇADO, listOf(kotlinBasico, projetoKotlin, coroutines))

    //Criando Alunos
    val aluno1 = Aluno(1, "Victor", 20)
    val aluno2 = Aluno(2, "Gabriel", null)
    val aluno3 = Aluno(3, "Cesar", 22)

    formacaoKotlin.matricular(aluno1)
    formacaoKotlin.matricular(aluno2)
    formacaoKotlin.matricular(aluno3)

    try {
        formacaoKotlin.matricular(aluno2)
    } catch (e: IllegalArgumentException) {
        println("ERRO na matrícula: ${e.message}\n")
    }

    val duracaototal = formacaoKotlin.duracaoTotal()
    println ("A duração total da formação ${formacaoKotlin.nome} é de ${duracaototal} minutos\n")

    println("- Lista de inscritos na formação ${formacaoKotlin.nome} -")
    formacaoKotlin.inscritos.forEach { aluno ->
        println("- ${aluno.nome} (Id: ${aluno.id})")
    }
}
