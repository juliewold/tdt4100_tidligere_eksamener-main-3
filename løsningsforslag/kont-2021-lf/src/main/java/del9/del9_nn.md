# Del 8 - Funksjonelle grensesnitt og listehandteringar 

Fyll ut [UniversityHandbookUtils](UniversityHandbookUtils.java) metodane sine for operasjonar på ei liste med [Course](Course.java)-objekt.


- *getCourseNames(List<Course> courses)* - Returnerer ei liste med namna til alle emna
- *getCourseProperties(List<Course> courses, Function<Course, String> function)* - Returnerer alle emner transformerte ved hjelp av funksjonen
- *calculateGradesSummary(List<Course> courses, BinaryOperator<Double> operator)* - Returnerer eit samandrag av alle karaktersnitta til emna ved hjelp av operatoren. 
- *getCoursesYouCanTake(List<Course> courses, List<Course> takenCourses)* - Returnerer alle emnenne der du tilfredstiller alle forkunnskapskravene (takenCourses representerer her emna du tidlegare har tatt)