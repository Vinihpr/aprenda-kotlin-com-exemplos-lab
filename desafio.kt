enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} foi matriculado na formação: $nome")
    }

    fun listarInscritos() {
        if (inscritos.isEmpty()) {
            println("Nenhum usuário matriculado na formação: $nome")
        } else {
            println("Usuários matriculados na formação: $nome")
            inscritos.forEach { println(it.nome) }
        }
    }
}

fun main() {
    val usuario1 = Usuario("Vinicius")
    val usuario2 = Usuario("Maria")
    val usuario3 = Usuario("José")

    val conteudo1 = ConteudoEducacional("Introdução à Kotlin", 120)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 180)

    val formacaoBasica = Formacao("Curso Básico de Kotlin", Nivel.BASICO, listOf(conteudo1))
    val formacaoAvancada = Formacao("Curso Avançado de Kotlin", Nivel.DIFICIL, listOf(conteudo1, conteudo2))

    formacaoBasica.matricular(usuario1)
    formacaoBasica.matricular(usuario2)

    formacaoAvancada.matricular(usuario2)
    formacaoAvancada.matricular(usuario3)

    formacaoBasica.listarInscritos()
    formacaoAvancada.listarInscritos()
}