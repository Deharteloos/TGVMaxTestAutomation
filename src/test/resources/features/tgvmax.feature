# language: en
Feature: TGVmax bugs

  @severity=minor
  @bug_1369
  Scenario: Google plus page unavailable
    Given Go to page "https://www.tgvmax.fr/VSC/fr-FR"
    When  Scroll down to footer
    Then The Google+ icon is no longer visible


  @severity=minor
  @bug_1353  
  Scenario: Empty language list
    Given Go to page "https://www.tgvmax.com/trainline/"
    When Click on "Top 6 des questions" and click on "A quels trains puis-je accéder avec mon abonnement TGVmax?"
    And Click on "ici" in the text
    And Click on the French flag in the navbar
    Then The list of languages is empty


  @severity=critical
  @bug_1263 
  Scenario: Redirection to an inaccessible page
    Given Go to page "https://www.tgvmax.fr/VSC/fr-FR"
    When Click on  "Tout ce qu’il faut savoir sur TGVmax" and click on "Y a-t-il des principes propres à TGVmax que je dois connaître?"
    And Click on "Espace Max"
    Then The page is inaccessible with "http://localhost/<id_agence>/fr-FR/factures"