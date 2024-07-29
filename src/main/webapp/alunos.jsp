<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="index.css" type="text/css">
  <title>Alunos</title>
</head>
<body>
	<main>
		<s:a action="registrarAluno" cssClass="botao">Registrar</s:a>
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>CPF</th>
					<th>Idade</th>
				</tr>
			</thead>
			<tbody>
			<s:iterator value="alunos">
				<tr>
					<td><s:property value="nome" /></td>
					<td><s:property value="email" /></td>
					<td><s:property value="cpf" /></td>
					<td><s:property value="idade" /></td>
					<td>
						<s:a action="editarAluno">
							<s:param name="id"><s:property value="id" /></s:param>
							editar
						</s:a>
					</td>
					<td>
						<s:a action="excluirAluno">
							<s:param name="id"><s:property value="id" /></s:param>
							excluir
						</s:a>
					</td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
	</main>
</body>
</html>