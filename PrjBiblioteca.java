import java.time.LocalDate;

class GerenciarBiblioteca {

    // Classe base Usuario
    static class Usuario {
        private int idUsuario;
        private String nome;
        private String email;

        public Usuario(int idUsuario, String nome, String email) {
            this.idUsuario = idUsuario;
            this.nome = nome;
            this.email = email;
        }

        public int getIdUsuario() {
            return idUsuario;
        }

        public String getNome() {
            return nome;
        }

        public String getEmail() {
            return email;
        }
    }

    // Subclasse Aluno
    static class Aluno extends Usuario {
        private String matricula;
        private String curso;

        public Aluno(int idUsuario, String nome, String email, String matricula, String curso) {
            super(idUsuario, nome, email);
            this.matricula = matricula;
            this.curso = curso;
        }

        public String getMatricula() {
            return matricula;
        }

        public String getCurso() {
            return curso;
        }
    }

    // Subclasse Professor
    static class Professor extends Usuario {
        private String departamento;
        private String titulacao;

        public Professor(int idUsuario, String nome, String email, String departamento, String titulacao) {
            super(idUsuario, nome, email);
            this.departamento = departamento;
            this.titulacao = titulacao;
        }

        public String getDepartamento() {
            return departamento;
        }

        public String getTitulacao() {
            return titulacao;
        }
    }

    // Subclasse Funcionario
    static class Funcionario extends Usuario {
        private String cargo;
        private String setor;

        public Funcionario(int idUsuario, String nome, String email, String cargo, String setor) {
            super(idUsuario, nome, email);
            this.cargo = cargo;
            this.setor = setor;
        }

        public String getCargo() {
            return cargo;
        }

        public String getSetor() {
            return setor;
        }
    }

    // Classe Livro
    static class Livro {
        private int idLivro;
        private String titulo;
        private String autor;
        private boolean disponivel;

        public Livro(int idLivro, String titulo, String autor, boolean disponivel) {
            this.idLivro = idLivro;
            this.titulo = titulo;
            this.autor = autor;
            this.disponivel = disponivel;
        }

        public int getIdLivro() {
            return idLivro;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        public boolean isDisponivel() {
            return disponivel;
        }

        public void setDisponivel(boolean disponivel) {
            this.disponivel = disponivel;
        }
    }

    // Classe RegistroEmprestimo
    static class RegistroEmprestimo {
        private int idEmprestimo;
        private Usuario usuario;
        private Livro livro;
        private LocalDate dataEmprestimo;
        private LocalDate dataDevolucao;

        public RegistroEmprestimo(int idEmprestimo, Usuario usuario, Livro livro, LocalDate dataEmprestimo) {
            this.idEmprestimo = idEmprestimo;
            this.usuario = usuario;
            this.livro = livro;
            this.dataEmprestimo = dataEmprestimo;
            this.dataDevolucao = null;
        }

        public int getIdEmprestimo() {
            return idEmprestimo;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public Livro getLivro() {
            return livro;
        }

        public LocalDate getDataEmprestimo() {
            return dataEmprestimo;
        }

        public LocalDate getDataDevolucao() {
            return dataDevolucao;
        }

        public void setDataDevolucao(LocalDate dataDevolucao) {
            this.dataDevolucao = dataDevolucao;
        }
    }

    // Classe ControleEmprestimo
    static class ControleEmprestimo {
        private int contadorEmprestimos = 0;

        public String registraEmprestimo(Usuario usuario, Livro livro) {
            if (!livro.isDisponivel()) {
                return "O livro não está disponível para empréstimo.";
            }
            livro.setDisponivel(false);
            contadorEmprestimos++;
            RegistroEmprestimo registro = new RegistroEmprestimo(contadorEmprestimos, usuario, livro, LocalDate.now());
            return "Empréstimo registrado:\n" +
                    "Usuário: " + usuario.getNome() + "\n" +
                    "Livro: " + livro.getTitulo() + "\n" +
                    "Data do Empréstimo: " + registro.getDataEmprestimo();
        }

        public String registraDevolucao(Usuario usuario, Livro livro) {
            livro.setDisponivel(true);
            return "Devolução registrada:\n" +
                    "Usuário: " + usuario.getNome() + "\n" +
                    "Livro: " + livro.getTitulo() + "\n" +
                    "Data da Devolução: " + LocalDate.now();
        }
    }

    // Método main
    public static void main(String[] args) {
        Aluno aluno = new Aluno(1, "João Silva", "joao@example.com", "202020", "Engenharia");
        Professor professor = new Professor(2, "Maria Oliveira", "maria@example.com", "Ciências", "Doutora");
        Funcionario funcionario = new Funcionario(3, "Carlos Pereira", "carlos@example.com", "Bibliotecário", "Setor A");

        Livro livro1 = new Livro(1, "Java para Iniciantes", "John Doe", true);
        Livro livro2 = new Livro(2, "POO com Java", "Jane Doe", true);

        ControleEmprestimo controle = new ControleEmprestimo();

        System.out.println(controle.registraEmprestimo(aluno, livro1));
        System.out.println(controle.registraEmprestimo(professor, livro2));
        System.out.println(controle.registraDevolucao(aluno, livro1));
        System.out.println(controle.registraDevolucao(professor, livro2));
    }
}
