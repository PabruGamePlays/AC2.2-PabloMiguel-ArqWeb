package com.example.tarefa_4_api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.tarefa_4_api.dtos.DadosCursosDTO;
import com.example.tarefa_4_api.models.Agenda;
import com.example.tarefa_4_api.models.Cursos;
import com.example.tarefa_4_api.models.Professores;
import com.example.tarefa_4_api.repositories.AgendaRepository;
import com.example.tarefa_4_api.repositories.CursosRepository;
import com.example.tarefa_4_api.repositories.ProfessoresRepository;
import com.example.tarefa_4_api.services.CursosService;
import com.example.tarefa_4_api.services.ProfessoresService;

@SpringBootApplication
public class Tarefa4ApiApplication {

	@Bean
	public CommandLineRunner init(
		@Autowired AgendaRepository agendaRepository,
		@Autowired CursosRepository cursosRepository,
		@Autowired ProfessoresRepository professoresRepository,
		@Autowired CursosService cursosService,
		@Autowired ProfessoresService professoresService
	){
		return args ->{
			Professores p1 = new Professores(0, "Johnny Depp", "321654987", "159734682", "Votorantim", "15 98746-1523");
			Professores p2 = new Professores(0, "Bruce Wayne", "456123789", "17389285",  "Diadema", "11 91065-4432");
			Professores p3 = new Professores(0, "Tony Stark", "147852369", "346782902", "Salto de Pirapora", "15 92401-7070");

			p1 = professoresRepository.save(p1);
			p2 = professoresRepository.save(p2);
			p3 = professoresRepository.save(p3);
			
			professoresRepository.findAll();

			Cursos c1 = new Cursos(0, "Medicina Veterinária", 93540.0, "O objetivo primordial do curso de Medicina Veterinária da Facens é capacitar profissionais generalistas com uma sólida base técnica, que se destaquem como pensadores críticos, estejam atualizados com as demandas do mundo contemporâneo.", "Nesse contexto, o curso de veterinária foi concebido com ênfase na formação de habilidades práticas desde o início, acompanhando a crescente complexidade e as competências exigidas para proporcionar uma formação singular e excepcional nos 5 anos de graduação.");

			Cursos c2 = new Cursos(0, "Arquitetura de Software", 1480.0, "Aprender habilidades essenciais, aplicando metodologias ágeis, além de conhecer as estratégias de um projeto de desenvolvimento de um sistema.", "Apresenta de forma clara, simples e didática as necessidades técnicas de um arquiteto de software, capacitando desenvolvedores a exercer o papel de arquiteto com práticas atuais de mercado.");

			Cursos c3 = new Cursos(0, "Engenharia Civil", 4320.0, "O curso de Engenharia Civil oferece uma formação técnica sólida e promove a aprendizagem baseada em projetos desde o início, desenvolvendo habilidades interpessoais cruciais. Além das aulas, os estudantes participam de visitas técnicas, workshops, feiras e eventos práticos.", "A Engenharia Civil é essencial para criar infraestruturas e edificações que impactam a sociedade. Os engenheiros civis desempenham um papel fundamental no planejamento e construção de projetos. Se você busca uma carreira dinâmica e desafiadora, junte-se a nós e ajude a moldar o futuro.");

			Cursos c4 = new Cursos(0, "Análise e Desenvolvimento de Sistemas", 2960.0, "Tecnologia em Análise e Desenvolvimento de Sistemas é um curso hands-on, em que você aprende a solucionar problemas reais. Um curso que também conta com a participação de grandes empresas do mercado de TI, por meio do programa de parcerias estratégicas da Facens.", "Você vai criar aplicações WEB e Desenvolver Aplicativos Mobile (Android e iOS), além de adquirir conhecimentos em Modelagem de Sistemas, Suporte à Área de Negócios, Geração de Informação, Criação de Aplicações sob Medida, Integração de Sistemas e também colocar em prática novas tecnologias como Big Data.");

			Cursos c5 = new Cursos(0, "Arquitetura e Urbanismo", 5810.0, "O curso de Arquitetura e Urbanismo da Facens busca formar um profissional crítico e multidisciplinar, capaz de identificar as melhores práticas e inovações, especialmente no que diz respeito à qualidade e diversidade socioambiental.", "Área responsável pelo projeto, planejamento e execução de edificações, conjuntos arquitetônicos e monumentos, arquitetura paisagística e de interiores, planejamento físico, local, urbano e regional, paisagismo, seus serviços afins e correlatos.");

			Cursos c6 = new Cursos(0, "Ciência de Dados", 8765.0, "O volume de dados gerados por empresas e usuários, são um dos desafios da era tecnológica, tornando-se mandatório a presença de um especialista que organize essas informações e faça bom uso delas.", "O especialista em Big Data, ou Cientista de Dados, é o responsável por reconhecer padrões, extrair informações úteis ao negócio, fazer previsões e tomar decisões em empreendimentos e em todos os níveis da indústria.");
			
			Cursos c7 = new Cursos(0, "Engenharia de Segurança do Trabalho", 7680.0, "Se tornar um profissional qualificado em identificar perigos, analisar riscos de acidentes do trabalho e eliminar ou mitigar os seus efeitos quanto a danos pessoais, materiais ou ambientais com medidas de Engenharia, Administrativas ou de proteções coletivas e individuais.", "Engenheiros e Arquitetos que terão o registro da especialização anotado na carteira do CREA – Conselho Regional de Engenharia, Arquitetura e Agronomia e no CAU – Conselho de Arquitetura e Urbanismo, respectivamente.");
			
			c1 = cursosRepository.save(c1);
			c2 = cursosRepository.save(c2);
			c3 = cursosRepository.save(c3);
			c4 = cursosRepository.save(c4);
			c5 = cursosRepository.save(c5);
			c6 = cursosRepository.save(c6);
			c7 = cursosRepository.save(c7);

			cursosRepository.findAll();

			Cursos cursos = cursosRepository.findById(5).orElseThrow();
			Professores professores = professoresRepository.findById(1).orElseThrow();

			cursos.getProfessores().add(professores);
			cursosRepository.save(cursos);

			cursos = cursosRepository.findById(6).orElseThrow();
			professores = professoresRepository.findById(1).orElseThrow();

			cursos.getProfessores().add(professores);
			cursosRepository.save(cursos);

			cursos = cursosRepository.findById(5).orElseThrow();
			professores = professoresRepository.findById(2).orElseThrow();

			cursos.getProfessores().add(professores);
			cursosRepository.save(cursos);

			cursos = cursosRepository.findById(4).orElseThrow();
			professores = professoresRepository.findById(3).orElseThrow();

			cursos.getProfessores().add(professores);
			cursosRepository.save(cursos);

			cursosRepository.findAll();
			professoresRepository.findAll();

			System.out.println("\nCursos encontrados pelo ID \n");
			DadosCursosDTO c = cursosService.obtainById(4);
			System.out.println(c);

			Agenda ag1 = new Agenda(0, LocalDate.parse("2024-01-10"), LocalDate.parse("2024-01-20"), "8:00", "17:00", "São Bernardo do Campo", "SP", "20403910");
			Agenda ag2 = new Agenda(0, LocalDate.parse("2024-03-17"), LocalDate.parse("2024-03-31"), "8:00", "19:00", "Santos", "SP", "9654130");
			Agenda ag3 = new Agenda(0, LocalDate.parse("2024-03-09"), LocalDate.parse("2024-03-29"), "8:00", "12:00", "Sorocaba", "SP", "7225498");
			Agenda ag4 = new Agenda(0, LocalDate.parse("2024-05-06"), LocalDate.parse("2024-05-27"), "8:00", "18:00", "Campinas", "SP", "8637491");

			ag1 = agendaRepository.save(ag1);
			ag2 = agendaRepository.save(ag2);
			ag3 = agendaRepository.save(ag3);
			ag4 = agendaRepository.save(ag4);

			List<Agenda> listaAgendas = agendaRepository.findAll();
			
			listaAgendas.get(0).setCursos(c5);
			listaAgendas.get(0).setProfessores(p1);
			agendaRepository.save(listaAgendas.get(0));

			listaAgendas.get(1).setCursos(c6);
			listaAgendas.get(1).setProfessores(p1);
			agendaRepository.save(listaAgendas.get(1));

			listaAgendas.get(2).setCursos(c5);
			listaAgendas.get(2).setProfessores(p2);
			agendaRepository.save(listaAgendas.get(2));

			listaAgendas.get(3).setCursos(c4);
			listaAgendas.get(3).setProfessores(p3);
			agendaRepository.save(listaAgendas.get(3));

			listaAgendas.forEach(System.out::println);

			System.out.println("\n ** Agenda de Professores ** \n");
			List<Professores> p = professoresRepository.findProfessoresFetchAgenda(1);
			System.out.println(p);

			System.out.println("\n ** Agenda de Professores ** \n");
			List<Agenda> a = agendaRepository.findAgendaByIdProfessoresFetchProfessores(1);
			System.out.println(a);

			System.out.println("\n ** Professor Está com Agenda na Data Determinada ** \n");
			Agenda a1 = agendaRepository.findAgendaFetchDataInicioProfessores(LocalDate.parse("2024-03-09"), 1);
			System.out.println(a1);
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(Tarefa4ApiApplication.class, args);
	}

}
