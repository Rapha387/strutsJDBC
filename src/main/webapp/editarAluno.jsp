<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="index.css" type="text/css">
  <title>Editar Aluno</title>
</head>
<body>
  <main>
    <s:form action="salvarEdicaoAluno.action" theme="simple">
      <div class="label-input">
        <label for="nome">Nome:</label>
        <s:textfield name="aluno.nome" id="nome" />
      </div>
      <div class="label-input">
        <label for="email">Email:</label>
        <s:textfield type="email" name="aluno.email" id="email" />
      </div>
      <div class="label-input">
        <label for="cpf">CPF:</label>
        <s:textfield type="text" name="aluno.cpf" id="cpf" />
      </div>
      <div class="label-input">
        <label for="idade">Idade:</label>
        <s:textfield type="number" name="aluno.idade" id="idade" />
      </div>
       <s:textfield type="hidden" name="aluno.id" value="%{id}" />
      <button>Enviar</button>
    </s:form>
  </main>
</body>
</html>