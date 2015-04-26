<%@ page import="toulousemusee.Musee; toulousemusee.Adresse" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
    <style type="text/css" media="screen">
    #status {
        background-color: #eee border : .2 em solid #fff;
        margin: 2em 2em 1em;
        padding: 1em;
        width: 12em;
        float: left;
        -moz-box-shadow: 0px 0px 1.25em #ccc;
        -webkit-box-shadow: 0px 0px 1.25em #ccc;
        box-shadow: 0px 0px 1.25em #ccc;
        -moz-border-radius: 0.6em;
        -webkit-border-radius: 0.6em;
        border-radius: 0.6em;
    }

    .ie6 #status {
        display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
    }

    #status ul {
        font-size: 0.9em;
        list-style-type: none;
        margin-bottom: 0.6em;
        padding: 0;
    }

    #status li {
        line-height: 1.3;
    }

    #status h1 {
        text-transform: uppercase;
        font-size: 1.1em;
        margin: 0 0 0.3em;
    }

    #page-body {
        margin: 2em 1em 1.25em 2em;
    }

    h2 {
        margin-top: 1em;
        margin-bottom: 0.3em;
        font-size: 1em;
    }

    p {
        line-height: 1.5;
        margin: 0.25em 0;
    }

    #controller-list ul {
        list-style-position: inside;
    }

    #controller-list li {
        line-height: 1.3;
        list-style-position: inside;
        margin: 0.25em 0;
    }

    @media screen and (max-width: 480px) {
        #status {
            display: none;
        }

        #page-body {
            margin: 0 1em 1em;
        }

        #page-body h1 {
            margin-top: 0;
        }
    }
    </style>
</head>

<body>
<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
%{--<div id="status" role="complementary">--}%
%{--<h1>Application Status</h1>--}%
%{--<ul>--}%
%{--<li>App version: <g:meta name="app.version"/></li>--}%
%{--<li>Grails version: <g:meta name="app.grails.version"/></li>--}%
%{--<li>Groovy version: ${GroovySystem.getVersion()}</li>--}%
%{--<li>JVM version: ${System.getProperty('java.version')}</li>--}%
%{--<li>Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</li>--}%
%{--<li>Controllers: ${grailsApplication.controllerClasses.size()}</li>--}%
%{--<li>Domains: ${grailsApplication.domainClasses.size()}</li>--}%
%{--<li>Services: ${grailsApplication.serviceClasses.size()}</li>--}%
%{--<li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>--}%
%{--</ul>--}%
%{--<h1>Installed Plugins</h1>--}%
%{--<ul>--}%
%{--<g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">--}%
%{--<li>${plugin.name} - ${plugin.version}</li>--}%
%{--</g:each>--}%
%{--</ul>--}%
%{--</div>--}%
<div id="page-body" role="main">
    %{--<h1>Welcome to Grails</h1>--}%
    %{--<p>Congratulations, you have successfully started your first Grails application! At the moment--}%
    %{--this is the default page, feel free to modify it to either redirect to a controller or display whatever--}%
    %{--content you may choose. Below is a list of controllers that are currently deployed in this application,--}%
    %{--click on each to execute its default action:</p>--}%

    <h1>Bienvenue sur Toulouse Musée</h1>

    <p>Vous pouvez consulter la liste des musées de la ville Toulouse en effectuant une recherche</p>

    <div id="controller-list" role="navigation">
        <h2>Rechercher des musées</h2>
        <g:form controller="musee">
            <fieldset class="form">
                <div class="fieldcontain">
                    <label>
                        Nom musée contient :
                    </label>
                    <g:textField name="nom"/>
                </div>

                <div class="fieldcontain">
                    <label for="codepostal">
                        Code postal:
                    </label>
                    <g:select from="${Adresse.list()}" optionValue="codePostal" optionKey="codePostal"
                              noSelection="['': '']" name="codepostal"/>
                </div>

                <div class="fieldcontain">
                    <label for="nomrue">
                        Nom rue contient:
                    </label>
                    <g:textField name="nomrue"/>
                </div>

                <div style="float: right">
                    <g:actionSubmit action="doSearchMusees" value="Rechercher"/>
                </div>
            </fieldset>
        </g:form>
    %{--<ul>--}%
    %{--<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">--}%
    %{--<li class="controller"><g:link--}%
    %{--controller="${c.logicalPropertyName}">${c.logicalPropertyName}</g:link></li>--}%
    %{--</g:each>--}%
    %{--</ul>--}%
    </div>
</div>
<g:if test="${toulousemusee.Musee.list().isPrefere.contains(true) == true}">
<div id="encart" style="float: right; right: 2%; top: 30%; font-size: 80%;">

    <table>
        <h1>Mes musées préférés</h1>
        <thead>
        <tr>
            %{--<g:sortableColumn property="nom" title="${message(code: 'musee.nom.label', default: 'Nom')}"/>--}%
            %{--<g:sortableColumn property="favoris" title="${message(code: 'musee.nom.label', default: 'Favoris')}"/>--}%
            <th>Nom</th>
            <th>Actions</th>
        </tr>
        </thead><tbody>
    <g:each in="${Musee.findAll()}" status="i" var="museeInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <g:if test="${museeInstance.isPrefere == true}">
                <td>${fieldValue(bean: museeInstance, field: "nom")}</td>

                <td><g:form id="${museeInstance.id}" controller="musee">
                    <g:actionSubmit action="doRemoveFavoris" value="Supprimer &#10 de ma liste de musée"/>
                    <g:actionSubmit action="doDemandeVisite" value="Effectuer &#10 une demande de visite"/>
                </g:form></td>
            </g:if>

        </tr>
    </g:each>
    </tbody>
    </table>
</div>
</g:if>
</body>
</html>
