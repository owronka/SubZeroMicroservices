@echo on

call mvn clean install spring-boot:repackage -DskipTests=true

