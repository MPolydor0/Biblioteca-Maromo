public class GerenciarBiblioteca {
    public static void main(String[] args) {
        // Instanciação de Aluno, Professor e Funcionário
        Aluno aluno = new Aluno(1, "João Silva", "joao@exemplo.com", "12345", "Ciência da Computação");
        Professor professor = new Professor(2, "Maria Souza", "maria@exemplo.com", "Matemática", "Doutora");
        Funcionario funcionario = new Funcionario(3, "Carlos Pereira", "carlos@exemplo.com", "Bibliotecário", "Biblioteca");

        // Instanciação de alguns livros
        Livro livro1 = new Livro(101, "Java Programming", "Autor X", true);
        Livro livro2 = new Livro(102, "Database Systems", "Autor Y", true);

        // Controle de Empréstimos
        ControleEmprestimo controle = new ControleEmprestimo();

        // Empréstimos
        System.out.println(controle.registraEmprestimo(aluno, livro1));
        System.out.println(controle.registraEmprestimo(professor, livro2));

        // Devoluções
        System.out.println(controle.registraDevolucao(aluno, livro1));
        System.out.println(controle.registraDevolucao(professor, livro2));
    }
}
