------------------------------------- CORRECTNESS PROOF ---------------------------------------
arvind@arvind-ThinkPad-Yoga-14:~/workspace/Bioinformatics_Nussinov/bin$ java -cp .: com.nussinov.sequential.Nussinov
3
1 millis
((.))(.).
0 0 0 1 2 2 2 3 3 
0 0 0 1 1 1 1 2 2 
0 0 0 0 0 0 0 1 1 
0 0 0 0 0 0 0 1 1 
0 0 0 0 0 0 0 1 1 
0 0 0 0 0 0 0 1 1 
0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 
arvind@arvind-ThinkPad-Yoga-14:~/workspace/Bioinformatics_Nussinov/bin$ java -cp .: com.nussinov.sequential.NussinovCacheOptimized 
3
1 millis
((.))(.).
0 0 0 1 2 2 2 3 3 
0 0 0 1 1 1 1 2 2 
0 0 0 0 0 0 0 1 1 
1 1 0 0 0 0 0 1 1 
2 1 0 0 0 0 0 1 1 
2 1 0 0 0 0 0 1 1 
2 1 0 0 0 0 0 0 0 
3 2 1 1 1 1 0 0 0 
3 2 1 1 1 1 0 0 0 
arvind@arvind-ThinkPad-Yoga-14:~/workspace/Bioinformatics_Nussinov/bin$ java -cp .: com.nussinov.parallel.NussinovOMP 
3
9 millis
((.))(.).
0 0 0 1 2 2 2 3 3 
0 0 0 1 1 1 1 2 2 
0 0 0 0 0 0 0 1 1 
0 0 0 0 0 0 0 1 1 
0 0 0 0 0 0 0 1 1 
0 0 0 0 0 0 0 1 1 
0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 
arvind@arvind-ThinkPad-Yoga-14:~/workspace/Bioinformatics_Nussinov/bin$ java -cp .: com.nussinov.parallel.NussinovCacheOptimized 
3
9 millis
((.))(.).
0 0 0 1 2 2 2 3 3 
0 0 0 1 1 1 1 2 2 
0 0 0 0 0 0 0 1 1 
1 1 0 0 0 0 0 1 1 
2 1 0 0 0 0 0 1 1 
2 1 0 0 0 0 0 1 1 
2 1 0 0 0 0 0 0 0 
3 2 1 1 1 1 0 0 0 
3 2 1 1 1 1 0 0 0 
arvind@arvind-ThinkPad-Yoga-14:~/workspace/Bioinformatics_Nussinov/bin$ 

------------------------------------- TIME PROOF ---------------------------------------

arvind@arvind-ThinkPad-Yoga-14:~/workspace/Bioinformatics_Nussinov/bin$ java -cp .: com.nussinov.sequential.Nussinov
1093
20655 millis
.(((((((((..)))((.).).)))).))(((.(.((.))(((((.((.((((.)(.).(((.((.((((((.((.(.(((.((((((.))))(.(((.).))))).(.)(.)).)((((.((((((.((((.((.).))(.))))))(((...).)))))))))))((((.))))))).(.))))))(((.)((((((((((.(.)((..))))((.))((((((((.(((.(.(((.))((((.))((..)((.)))))))(.).)))(((..((.((.)((((..)((((((.)((((.(.)((.)))))))).((((...(.)))))(((.)))))(((((.(((.)(((..(..).))))).))((((((.(.)))))))(((.)(.((((.)))(.)))))).))(.)))))))))))))))))))))(.)(.).))(((((.)(.)(((((..((.(((((((.((.))(((.((.(..)((((((((.).)))(((((.)(((((((((((.))((.)((((((.)(((.))))((((.).(((((((((.))(((.).))))(((.)(((((.(((((.(.((((((((((((((.))(((.((((((.)).))))(((((((.)).(((.))))(((((.((((.))))(((((((((.(((.)(.(.)((((((((((((.(((((.)(((((((((.)))))((((((.((..(..)(.(.((((((((((.))(.((.((((.))(..)(.)((..)))))(((((.))((((.)(.)))))(((((.(((...))))))(.)))))))))(.((((..)))(((((.(.)((((.)))).)))))).))).)))).(.)))))))))(((.)(.).)))..)(.))))))).))))((.).)))(.((((.)((..)).))(((.)(.))))((.)))))))((..)(.))(((.(((((.)))))(.).))))))))))))))).)((.)))((((((((((((.))))(.((((.)((..)))(((.)))).))).)))((.))(.))))((.))))))((.)))).)).))))((.(.))))))(.)((.).)))))((.)((((((..)(((.)))))(.)))))((((.))((((((.)(((((.((.(((((.(((.((((.)))(((.(.((((((.).)((((((.(.))(((((((((.(.)((((.)))))))))))((((.)((((((.)((((..))((.)))))))))))((.(((.)))((((((((.(.((((.)).))))((.(((((((..)((.))))))((((((((((((.).))(.))(((((.))).)((((((.)(((.))))))((..))))))(.(.(.)))))).))))))))((((.)).))).))).))((((((.)(.).))))(((((((.)((((((..)).))((((((((((((((.)(((((((((((((((.(((.)(((((.)))))))).))))(((..))).).))(.)((((((.)(((((((((.)((((((..))))((.(.).)))(((((.(.)).))(.))))))))(.((((.(((((.))((.)))((.((..)))))((((((((.)).)))).)(.)))))))))))))).)))))))((((.((.((((.)(((((((((.)))(.(((.((((((.((((.)(.((.((.).))))(.(.)))))((.))))((((.))((..))(.))(.))))))))))((.(..))))))))))).)))(((((..).(.)))))))))))((.(((..(((.(.).)))))))))))((.)(((.)))(((.))((((.)))))((.).))(((((.))(...))((.)(((.)))))))).))))(((.((((.(.)))))(.)))(((.)))(.))))))))((((.))).)))).))(.))))))))))...)))).))))).))))..))))))(((((.))))).))).(.)))))).))(..)).)(.)))))))(.))(((((.(((.))))(((.(((((.)((((((.))(.))))((.))).))))((((.)))(((.)((..)(((((((((((((((.)))(.(.(.)))(.))))))))...)((...))))((.)((..)))).)))(.))))))))))...)))))).)))))(((.)))(.)))))))(((.((.)).))))))))((((.)(.)(.))))(((..))))))((.)((((..((.(.)).)))))))))...)))).((.))(.)))).))((.).((((.)))(((((.))(.)((((((..)))))((..)))))))))))(((.))(.))))(((.((.))(((((.).)))))))))((.(.))).(.)(.)).)))((((..)))))))))))))))(((.)))))))))(.(.)))).)((.))))((((.(((.((((((((((.(.)))((((((.))(.)).)((.((((.)))))(((((.))))((((.))((((..)(.)))(.))((.))))))))))(((.)))(..).)))))(.))))))).))).)))))))))))).))))).))))((((.))((.)))))))(((.)))))((.).))......................
arvind@arvind-ThinkPad-Yoga-14:~/workspace/Bioinformatics_Nussinov/bin$ java -cp .: com.nussinov.sequential.NussinovCacheOptimized 
1093
6347 millis
.(((((((((..)))((.).).)))).))(((.(.((.))(((((.((.((((.)(.).(((.((.((((((.((.(.(((.((((((.))))(.(((.).))))).(.)(.)).)((((.((((((.((((.((.).))(.))))))(((...).)))))))))))((((.))))))).(.))))))(((.)((((((((((.(.)((..))))((.))((((((((.(((.(.(((.))((((.))((..)((.)))))))(.).)))(((..((.((.)((((..)((((((.)((((.(.)((.)))))))).((((...(.)))))(((.)))))(((((.(((.)(((..(..).))))).))((((((.(.)))))))(((.)(.((((.)))(.)))))).))(.)))))))))))))))))))))(.)(.).))(((((.)(.)(((((..((.(((((((.((.))(((.((.(..)((((((((.).)))(((((.)(((((((((((.))((.)((((((.)(((.))))((((.).(((((((((.))(((.).))))(((.)(((((.(((((.(.((((((((((((((.))(((.((((((.)).))))(((((((.)).(((.))))(((((.((((.))))(((((((((.(((.)(.(.)((((((((((((.(((((.)(((((((((.)))))((((((.((..(..)(.(.((((((((((.))(.((.((((.))(..)(.)((..)))))(((((.))((((.)(.)))))(((((.(((...))))))(.)))))))))(.((((..)))(((((.(.)((((.)))).)))))).))).)))).(.)))))))))(((.)(.).)))..)(.))))))).))))((.).)))(.((((.)((..)).))(((.)(.))))((.)))))))((..)(.))(((.(((((.)))))(.).))))))))))))))).)((.)))((((((((((((.))))(.((((.)((..)))(((.)))).))).)))((.))(.))))((.))))))((.)))).)).))))((.(.))))))(.)((.).)))))((.)((((((..)(((.)))))(.)))))((((.))((((((.)(((((.((.(((((.(((.((((.)))(((.(.((((((.).)((((((.(.))(((((((((.(.)((((.)))))))))))((((.)((((((.)((((..))((.)))))))))))((.(((.)))((((((((.(.((((.)).))))((.(((((((..)((.))))))((((((((((((.).))(.))(((((.))).)((((((.)(((.))))))((..))))))(.(.(.)))))).))))))))((((.)).))).))).))((((((.)(.).))))(((((((.)((((((..)).))((((((((((((((.)(((((((((((((((.(((.)(((((.)))))))).))))(((..))).).))(.)((((((.)(((((((((.)((((((..))))((.(.).)))(((((.(.)).))(.))))))))(.((((.(((((.))((.)))((.((..)))))((((((((.)).)))).)(.)))))))))))))).)))))))((((.((.((((.)(((((((((.)))(.(((.((((((.((((.)(.((.((.).))))(.(.)))))((.))))((((.))((..))(.))(.))))))))))((.(..))))))))))).)))(((((..).(.)))))))))))((.(((..(((.(.).)))))))))))((.)(((.)))(((.))((((.)))))((.).))(((((.))(...))((.)(((.)))))))).))))(((.((((.(.)))))(.)))(((.)))(.))))))))((((.))).)))).))(.))))))))))...)))).))))).))))..))))))(((((.))))).))).(.)))))).))(..)).)(.)))))))(.))(((((.(((.))))(((.(((((.)((((((.))(.))))((.))).))))((((.)))(((.)((..)(((((((((((((((.)))(.(.(.)))(.))))))))...)((...))))((.)((..)))).)))(.))))))))))...)))))).)))))(((.)))(.)))))))(((.((.)).))))))))((((.)(.)(.))))(((..))))))((.)((((..((.(.)).)))))))))...)))).((.))(.)))).))((.).((((.)))(((((.))(.)((((((..)))))((..)))))))))))(((.))(.))))(((.((.))(((((.).)))))))))((.(.))).(.)(.)).)))((((..)))))))))))))))(((.)))))))))(.(.)))).)((.))))((((.(((.((((((((((.(.)))((((((.))(.)).)((.((((.)))))(((((.))))((((.))((((..)(.)))(.))((.))))))))))(((.)))(..).)))))(.))))))).))).)))))))))))).))))).))))((((.))((.)))))))(((.)))))((.).))......................
arvind@arvind-ThinkPad-Yoga-14:~/workspace/Bioinformatics_Nussinov/bin$ java -cp .: com.nussinov.parallel.NussinovOMP 
1093
7946 millis
.(((((((((..)))((.).).)))).))(((.(.((.))(((((.((.((((.)(.).(((.((.((((((.((.(.(((.((((((.))))(.(((.).))))).(.)(.)).)((((.((((((.((((.((.).))(.))))))(((...).)))))))))))((((.))))))).(.))))))(((.)((((((((((.(.)((..))))((.))((((((((.(((.(.(((.))((((.))((..)((.)))))))(.).)))(((..((.((.)((((..)((((((.)((((.(.)((.)))))))).((((...(.)))))(((.)))))(((((.(((.)(((..(..).))))).))((((((.(.)))))))(((.)(.((((.)))(.)))))).))(.)))))))))))))))))))))(.)(.).))(((((.)(.)(((((..((.(((((((.((.))(((.((.(..)((((((((.).)))(((((.)(((((((((((.))((.)((((((.)(((.))))((((.).(((((((((.))(((.).))))(((.)(((((.(((((.(.((((((((((((((.))(((.((((((.)).))))(((((((.)).(((.))))(((((.((((.))))(((((((((.(((.)(.(.)((((((((((((.(((((.)(((((((((.)))))((((((.((..(..)(.(.((((((((((.))(.((.((((.))(..)(.)((..)))))(((((.))((((.)(.)))))(((((.(((...))))))(.)))))))))(.((((..)))(((((.(.)((((.)))).)))))).))).)))).(.)))))))))(((.)(.).)))..)(.))))))).))))((.).)))(.((((.)((..)).))(((.)(.))))((.)))))))((..)(.))(((.(((((.)))))(.).))))))))))))))).)((.)))((((((((((((.))))(.((((.)((..)))(((.)))).))).)))((.))(.))))((.))))))((.)))).)).))))((.(.))))))(.)((.).)))))((.)((((((..)(((.)))))(.)))))((((.))((((((.)(((((.((.(((((.(((.((((.)))(((.(.((((((.).)((((((.(.))(((((((((.(.)((((.)))))))))))((((.)((((((.)((((..))((.)))))))))))((.(((.)))((((((((.(.((((.)).))))((.(((((((..)((.))))))((((((((((((.).))(.))(((((.))).)((((((.)(((.))))))((..))))))(.(.(.)))))).))))))))((((.)).))).))).))((((((.)(.).))))(((((((.)((((((..)).))((((((((((((((.)(((((((((((((((.(((.)(((((.)))))))).))))(((..))).).))(.)((((((.)(((((((((.)((((((..))))((.(.).)))(((((.(.)).))(.))))))))(.((((.(((((.))((.)))((.((..)))))((((((((.)).)))).)(.)))))))))))))).)))))))((((.((.((((.)(((((((((.)))(.(((.((((((.((((.)(.((.((.).))))(.(.)))))((.))))((((.))((..))(.))(.))))))))))((.(..))))))))))).)))(((((..).(.)))))))))))((.(((..(((.(.).)))))))))))((.)(((.)))(((.))((((.)))))((.).))(((((.))(...))((.)(((.)))))))).))))(((.((((.(.)))))(.)))(((.)))(.))))))))((((.))).)))).))(.))))))))))...)))).))))).))))..))))))(((((.))))).))).(.)))))).))(..)).)(.)))))))(.))(((((.(((.))))(((.(((((.)((((((.))(.))))((.))).))))((((.)))(((.)((..)(((((((((((((((.)))(.(.(.)))(.))))))))...)((...))))((.)((..)))).)))(.))))))))))...)))))).)))))(((.)))(.)))))))(((.((.)).))))))))((((.)(.)(.))))(((..))))))((.)((((..((.(.)).)))))))))...)))).((.))(.)))).))((.).((((.)))(((((.))(.)((((((..)))))((..)))))))))))(((.))(.))))(((.((.))(((((.).)))))))))((.(.))).(.)(.)).)))((((..)))))))))))))))(((.)))))))))(.(.)))).)((.))))((((.(((.((((((((((.(.)))((((((.))(.)).)((.((((.)))))(((((.))))((((.))((((..)(.)))(.))((.))))))))))(((.)))(..).)))))(.))))))).))).)))))))))))).))))).))))((((.))((.)))))))(((.)))))((.).))......................
arvind@arvind-ThinkPad-Yoga-14:~/workspace/Bioinformatics_Nussinov/bin$ java -cp .: com.nussinov.parallel.NussinovCacheOptimized 
1093
4121 millis
.(((((((((..)))((.).).)))).))(((.(.((.))(((((.((.((((.)(.).(((.((.((((((.((.(.(((.((((((.))))(.(((.).))))).(.)(.)).)((((.((((((.((((.((.).))(.))))))(((...).)))))))))))((((.))))))).(.))))))(((.)((((((((((.(.)((..))))((.))((((((((.(((.(.(((.))((((.))((..)((.)))))))(.).)))(((..((.((.)((((..)((((((.)((((.(.)((.)))))))).((((...(.)))))(((.)))))(((((.(((.)(((..(..).))))).))((((((.(.)))))))(((.)(.((((.)))(.)))))).))(.)))))))))))))))))))))(.)(.).))(((((.)(.)(((((..((.(((((((.((.))(((.((.(..)((((((((.).)))(((((.)(((((((((((.))((.)((((((.)(((.))))((((.).(((((((((.))(((.).))))(((.)(((((.(((((.(.((((((((((((((.))(((.((((((.)).))))(((((((.)).(((.))))(((((.((((.))))(((((((((.(((.)(.(.)((((((((((((.(((((.)(((((((((.)))))((((((.((..(..)(.(.((((((((((.))(.((.((((.))(..)(.)((..)))))(((((.))((((.)(.)))))(((((.(((...))))))(.)))))))))(.((((..)))(((((.(.)((((.)))).)))))).))).)))).(.)))))))))(((.)(.).)))..)(.))))))).))))((.).)))(.((((.)((..)).))(((.)(.))))((.)))))))((..)(.))(((.(((((.)))))(.).))))))))))))))).)((.)))((((((((((((.))))(.((((.)((..)))(((.)))).))).)))((.))(.))))((.))))))((.)))).)).))))((.(.))))))(.)((.).)))))((.)((((((..)(((.)))))(.)))))((((.))((((((.)(((((.((.(((((.(((.((((.)))(((.(.((((((.).)((((((.(.))(((((((((.(.)((((.)))))))))))((((.)((((((.)((((..))((.)))))))))))((.(((.)))((((((((.(.((((.)).))))((.(((((((..)((.))))))((((((((((((.).))(.))(((((.))).)((((((.)(((.))))))((..))))))(.(.(.)))))).))))))))((((.)).))).))).))((((((.)(.).))))(((((((.)((((((..)).))((((((((((((((.)(((((((((((((((.(((.)(((((.)))))))).))))(((..))).).))(.)((((((.)(((((((((.)((((((..))))((.(.).)))(((((.(.)).))(.))))))))(.((((.(((((.))((.)))((.((..)))))((((((((.)).)))).)(.)))))))))))))).)))))))((((.((.((((.)(((((((((.)))(.(((.((((((.((((.)(.((.((.).))))(.(.)))))((.))))((((.))((..))(.))(.))))))))))((.(..))))))))))).)))(((((..).(.)))))))))))((.(((..(((.(.).)))))))))))((.)(((.)))(((.))((((.)))))((.).))(((((.))(...))((.)(((.)))))))).))))(((.((((.(.)))))(.)))(((.)))(.))))))))((((.))).)))).))(.))))))))))...)))).))))).))))..))))))(((((.))))).))).(.)))))).))(..)).)(.)))))))(.))(((((.(((.))))(((.(((((.)((((((.))(.))))((.))).))))((((.)))(((.)((..)(((((((((((((((.)))(.(.(.)))(.))))))))...)((...))))((.)((..)))).)))(.))))))))))...)))))).)))))(((.)))(.)))))))(((.((.)).))))))))((((.)(.)(.))))(((..))))))((.)((((..((.(.)).)))))))))...)))).((.))(.)))).))((.).((((.)))(((((.))(.)((((((..)))))((..)))))))))))(((.))(.))))(((.((.))(((((.).)))))))))((.(.))).(.)(.)).)))((((..)))))))))))))))(((.)))))))))(.(.)))).)((.))))((((.(((.((((((((((.(.)))((((((.))(.)).)((.((((.)))))(((((.))))((((.))((((..)(.)))(.))((.))))))))))(((.)))(..).)))))(.))))))).))).)))))))))))).))))).))))((((.))((.)))))))(((.)))))((.).))......................
arvind@arvind-ThinkPad-Yoga-14:~/workspace/Bioinformatics_Nussinov/bin$ 

