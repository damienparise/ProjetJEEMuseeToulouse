
<%@ page import="toulousemusee.Adresse; toulousemusee.Musee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-musee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-musee" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:form>
				<fieldset class="form">
					<div class="fieldcontain">
						<label for="nom">
							Nom musée contient :
						</label>
						<g:textField name="nom"/>
						<label for="codepostal">
							Code postal:
						</label>
						<g:select from="${Adresse.list()}" optionValue="codePostal" optionKey="codePostal" noSelection="['':'']" name="codepostal"/>
					</div>
					<div class="fieldcontain">
						<label for="nomrue">
							Nom rue contient:
						</label>
						<g:textField name="nomrue"/>
					</div>
					<div style="float: right">
						<g:actionSubmit action="doSearchMusees" value="Rechercher" />
					</div>
				</fieldset>

			</g:form>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="accesMetro" title="${message(code: 'musee.accesMetro.label', default: 'Acces Metro')}" />
					
						<g:sortableColumn property="accesBus" title="${message(code: 'musee.accesBus.label', default: 'Acces Bus')}" />
					
						<th><g:message code="musee.adresseMusee.label" default="Adresse Musee" /></th>
					
						<th><g:message code="musee.gestionnaire.label" default="Gestionnaire" /></th>
					
						<g:sortableColumn property="horairesOuverture" title="${message(code: 'musee.horairesOuverture.label', default: 'Horaires Ouverture')}" />
					
						<g:sortableColumn property="nom" title="${message(code: 'musee.nom.label', default: 'Nom')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${museeInstanceList}" status="i" var="museeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${museeInstance.id}">${fieldValue(bean: museeInstance, field: "accesMetro")}</g:link></td>
					
						<td>${fieldValue(bean: museeInstance, field: "accesBus")}</td>
					
						<td>${fieldValue(bean: museeInstance, field: "adresseMusee")}</td>
					
						<td>${fieldValue(bean: museeInstance, field: "gestionnaire")}</td>
					
						<td>${fieldValue(bean: museeInstance, field: "horairesOuverture")}</td>
					
						<td>${fieldValue(bean: museeInstance, field: "nom")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${museeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
