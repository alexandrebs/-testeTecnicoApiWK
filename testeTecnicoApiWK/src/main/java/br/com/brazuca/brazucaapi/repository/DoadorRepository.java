package br.com.brazuca.brazucaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.brazuca.brazucaapi.dto.ObesosDTO;
import br.com.brazuca.brazucaapi.entity.Doador;


@Repository
public interface DoadorRepository extends JpaRepository<Doador, Long>{

	//public boolean findByCpf(String cpf);
	public List<Doador> findByCpf(String cpf);
	


	
	/*
	Quantos candidatos temos nessa lista em cada estado do Brasil?
	*/
	@Query(name="buscarDoadoresPorEstado",
			value = "select d.estado as Estado, count(D.cpf) as total FROM doador_amazonas.tb_doador D\r\n"
					+ "group by  d.estado order by d.estado ",
			nativeQuery = true
			)
	public List<?> buscarDoadoresPorEstado();
	
	
	
	/*
		IMC médio em cada faixa de idade de dez em dez anos: 0 a 10; 11 a 20; 21 a 30, etc. (IMC = peso / altura)
	 */
	
	@Query(name="idadeMediaIMCFaixaIdade",
			value = "SELECT FAIXA_IDADE, SUM(IMC)/COUNT(FAIXA_IDADE)  FROM\r\n"
					+ "(SELECT \r\n"
					+ "CASE WHEN IDADE >= 0 AND IDADE <= 10 THEN '10'\r\n"
					+ " WHEN IDADE >= 11 AND IDADE <= 20 THEN '10-20'\r\n"
					+ " WHEN IDADE >= 21 AND IDADE <= 30 THEN '20-30'\r\n"
					+ " WHEN IDADE >= 31 AND IDADE <= 40 THEN '30-40'\r\n"
					+ " WHEN IDADE >= 41 AND IDADE <= 50 THEN '40-50'\r\n"
					+ " WHEN IDADE >= 51 AND IDADE <= 60 THEN '50-60'\r\n"
					+ " WHEN IDADE >= 61 AND IDADE <= 70 THEN '60-70'\r\n"
					+ " WHEN IDADE >= 71 AND IDADE <= 80 THEN '70-80'\r\n"
					+ " WHEN IDADE >= 81 AND IDADE <= 90 THEN '80-90'\r\n"
					+ " WHEN IDADE >= 91 AND IDADE <= 100 THEN '90-100'\r\n"
					+ " WHEN IDADE >= 101 AND IDADE <= 110 THEN '100-110'\r\n"
					+ " WHEN IDADE >= 111 AND IDADE <= 120 THEN '110-120'\r\n"
					+ " END AS FAIXA_IDADE, IMC\r\n"
					+ "FROM \r\n"
					+ "(SELECT  \r\n"
					+ "TRUNCATE(DATEDIFF(NOW(), c.data_nasc)/365.25, 0) AS IDADE,\r\n"
					+ "round(c.peso /(c.altura*c.altura)) as IMC\r\n"
					+ "FROM  doador_amazonas.tb_doador c\r\n"
					+ "group by Idade ORDER BY IDADE) A) B GROUP BY FAIXA_IDADE",
			nativeQuery = true
			)
	public List<?> idadeMediaIMCFaixaIdade();
	
	
	/*
	 * -- Qual o percentual de obesos entre os homens e entre as mulheres? (É obeso quem tem IMC >30)
	 */
	@Query(name="percentualObesos",
			value = "SELECT b.sexo, count(b.sexo) as total  FROM\r\n"
					+ "(select \r\n"
					+ "A.SEXO,\r\n"
					+ "CASE WHEN IMC > 30  THEN 'Obeso' \r\n"
					+ "	 WHEN IMC  <= 30  THEN 'Normal' \r\n"
					+ "END AS situacao,\r\n"
					+ "a.IMC\r\n"
					+ "from\r\n"
					+ "(\r\n"
					+ "SELECT  \r\n"
					+ "C.sexo,\r\n"
					+ "round(c.peso /(c.altura*c.altura)) as IMC\r\n"
					+ "FROM  doador_amazonas.tb_doador c\r\n"
					+ ") as a ) AS B\r\n"
					+ "WHERE B.situacao = 'OBESO'\r\n"
					+ "group by C.sexo ",
			nativeQuery = true
			)
	public List<ObesosDTO> percentualObesos();
	
	/*
	 * -- • Qual a média de idade para cada tipo sanguíneo?
	 */
	@Query(name="mediaIdadeTipoSanquineo",
			value = "SELECT\r\n"
					+ "c.tipo_sanguineo , \r\n"
					+ "round(SUM(TRUNCATE(DATEDIFF(NOW(), c.data_nasc)/365.25, 0))/count(c.tipo_sanguineo)) AS IDADE\r\n"
					+ "FROM  doador_amazonas.tb_doador c\r\n"
					+ "group by c.tipo_sanguineo order by c.tipo_sanguineo ",
			nativeQuery = true
			)
	public List<?> mediaIdadeTipoSanquineo();
	
	
	/*
	 * -- A quantidade de possíveis doadores para cada tipo sanguíneo receptor.
	 */
	
	@Query(name="qtdDoadoresTipoSanquineo",
			value = "SELECT totalDoadores as tipo_sanguineo, COUNT(tipo_sanguineo) total_doadores  FROM\r\n"
					+ "(SELECT \r\n"
					+ "CASE WHEN a.tipo_sanguineo = 'A+' or 'A-' or 'O+' or 'O-' THEN 'A+'\r\n"
					+ "	 WHEN a.tipo_sanguineo = 'A-' or 'O-' THEN 'A-'\r\n"
					+ "	 WHEN a.tipo_sanguineo = 'B+' or 'B-' or 'O+' or 'O-' THEN 'B+'\r\n"
					+ "	 WHEN a.tipo_sanguineo = 'B-' or 'B-' or 'O-' THEN 'B-'\r\n"
					+ "	 WHEN a.tipo_sanguineo = 'AB+' or 'A+' or 'B+' or 'O+' or 'AB+' or 'A-' or 'B-' or 'O-' or 'AB-' THEN 'AB+'\r\n"
					+ "	 WHEN a.tipo_sanguineo = 'AB-' or 'A-' or 'B-' or 'O-' or 'AB-' THEN 'AB-'\r\n"
					+ "	 WHEN a.tipo_sanguineo = 'O+' or 'O+' or 'O-' THEN 'O+'\r\n"
					+ "	 WHEN a.tipo_sanguineo = 'O-' or 'O-' THEN 'O-'\r\n"
					+ "	 \r\n"
					+ " END AS totalDoadores, \r\n"
					+ " a.tipo_sanguineo\r\n"
					+ "FROM \r\n"
					+ "(SELECT  \r\n"
					+ "c.tipo_sanguineo,\r\n"
					+ "TRUNCATE(DATEDIFF(NOW(), c.data_nasc)/365.25, 0) AS IDADE,\r\n"
					+ "round(c.peso /(c.altura*c.altura)) as IMC\r\n"
					+ "FROM  doador_amazonas.tb_doador c\r\n"
					+ "where \r\n"
					+ "TRUNCATE(DATEDIFF(NOW(), c.data_nasc)/365.25, 0) > 16 and\r\n"
					+ "TRUNCATE(DATEDIFF(NOW(), c.data_nasc)/365.25, 0) < 69 and\r\n"
					+ "c.peso >50\r\n"
					+ "group by Idade ORDER BY IDADE)\r\n"
					+ " A)\r\n"
					+ " B GROUP BY tipo_sanguineo order by tipo_sanguineo ",
			nativeQuery = true
			)
	public List<?> qtdDoadoresTipoSanquineo();
}
