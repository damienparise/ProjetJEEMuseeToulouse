<%@ page import="toulousemusee.DemandeVisite" %>



<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'nbPersonnes', 'error')} required">
	<label for="nbPersonnes">
		<g:message code="demandeVisite.nbPersonnes.label" default="Nb Personnes" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="nbPersonnes" from="${demandeVisiteInstance.constraints.nbPersonnes.inList}" required="" value="${fieldValue(bean: demandeVisiteInstance, field: 'nbPersonnes')}" valueMessagePrefix="demandeVisite.nbPersonnes"/>

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'statut', 'error')} required">
	<label for="statut">
		<g:message code="demandeVisite.statut.label" default="Statut" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="statut" from="${demandeVisiteInstance.constraints.statut.inList}" required="" value="${demandeVisiteInstance?.statut}" valueMessagePrefix="demandeVisite.statut"/>

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'codeVisite', 'error')} required">
	<label for="codeVisite">
		<g:message code="demandeVisite.codeVisite.label" default="Code Visite" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="codeVisite" required="" value="${demandeVisiteInstance?.codeVisite}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'dateDebutPeriode', 'error')} required">
	<label for="dateDebutPeriode">
		<g:message code="demandeVisite.dateDebutPeriode.label" default="Date Debut Periode" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateDebutPeriode" precision="day"  value="${demandeVisiteInstance?.dateDebutPeriode}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'dateFinPeriode', 'error')} required">
	<label for="dateFinPeriode">
		<g:message code="demandeVisite.dateFinPeriode.label" default="Date Fin Periode" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateFinPeriode" precision="day"  value="${demandeVisiteInstance?.dateFinPeriode}"  />

</div>

