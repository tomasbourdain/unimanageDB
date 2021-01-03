CREATE DATABASE  lab1;
 
 USE lab1;
 
 CREATE TABLE alunos(
		alu_id INT(11) NOT NULL AUTO_INCREMENT,
        alu_nome VARCHAR(60) NOT NULL,
        alu_local VARCHAR(30),
        alu_dnsc DATE NOT NULL,
        alu_sexo CHAR(1) NOT NULL,
        alu_email VARCHAR(30),
        alu_cur_id INT,
        PRIMARY KEY(alu_id)
);

CREATE TABLE cursos(
		cur_id INT(11) NOT NULL AUTO_INCREMENT,
        cur_nome VARCHAR(40),
        PRIMARY KEY (cur_id)
);

CREATE TABLE departamentos(
		dep_id INT(11) NOT NULL AUTO_INCREMENT,
        dep_nome VARCHAR(60) NOT NULL,
        dep_sigla VARCHAR(3) NOT NULL,
        PRIMARY KEY(dep_id)
);

CREATE TABLE disciplinas(
		dis_id INT(11) NOT NULL AUTO_INCREMENT,
        dis_nome VARCHAR(40) NOT NULL,
        dis_creditos TINYINT(4) NOT NULL,
        dis_dep_id INT(11),
        PRIMARY KEY (dis_id)
);

CREATE TABLE planoestudos(
		pla_cur_id INT(11) NOT NULL,
        pla_dis_id INT(11) NOT NULL,
        pla_semestre TINYINT(4) NOT NULL,
        PRIMARY KEY( pla_cur_id,pla_dis_id)
);

CREATE TABLE inscricoes(
		ins_id INT(11) NOT NULL AUTO_INCREMENT,
        ins_alu_id INT(11) NOT NULL,
        ins_pla_cur_id INT(11) NOT NULL,
        ins_pla_dis_id INT(11) NOT NULL,
        ins_dt_inscricao DATE NOT NULL,
        ins_dt_avaliacao DATE ,
        ins_nota DECIMAL(4,2),
		PRIMARY KEY (ins_id)
);
        
        
ALTER TABLE alunos ADD CONSTRAINT alunos_fk_cursos
            foreign key (alu_cur_id) references cursos(cur_id)
			ON DELETE NO ACTION ON UPDATE NO ACTION;
            
alter table disciplinas add constraint disciplinas_fk_departamentos
            foreign key (dis_dep_id) references departamentos(dep_id) 
			ON DELETE NO ACTION ON UPDATE NO ACTION;
            
alter table planoestudos add constraint planoestudos_fk_cursos
            foreign key (pla_cur_id) references cursos(cur_id) 
			ON DELETE NO ACTION ON UPDATE NO ACTION;            
            
alter table planoestudos add constraint planoestudos_fk_disciplinas
            foreign key (pla_cur_id) references disciplinas(dis_id) 
			ON DELETE NO ACTION ON UPDATE NO ACTION;            

alter table inscricoes add constraint inscricoes_fk_alunos
            foreign key (ins_alu_id) references alunos(alu_id) 
			ON DELETE NO ACTION ON UPDATE NO ACTION; 
                        
alter table inscricoes add constraint inscricoes_fk_planoestudos
            foreign key (ins_pla_cur_id,ins_pla_dis_id) references planoestudos(pla_cur_id,pla_dis_id) 
			ON DELETE NO ACTION ON UPDATE NO ACTION; 


            

        