package com.berstek.learningapp.test;

import com.berstek.learningapp.model.Intro;
import com.berstek.learningapp.model.MatchingImage;
import com.berstek.learningapp.model.MatchingQuestion;
import com.berstek.learningapp.model.Module;
import com.berstek.learningapp.model.Question;
import com.berstek.learningapp.model.Title;

public class DataInit {

  public Module getModule() {

    /*
    We initialize the module here
    //TODO get data online
     */

    Module module = new Module();
    module.setModuleHeader("Module 1");

    Title title = new Title();
    title.setTitle("MATH");
    title.setSubtitle("Understanding and Recognizing \"How Many\" in Sets of Objects");
    title.setImgUrl("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_math.jpg?alt=media&token=1bf2e476-64cd-40c1-ab59-07fbe2bcaa75");
    title.setModuleHeader("Module 1");
    title.setModuleNumber("1");
    module.setTitle(title);


    Intro intro = new Intro();
    intro.setTitle("To the Learner");
    intro.setHeader("Hello my dear learner! How are you? Today you are going to learn about understanding “how many” in set of objects. You will also know how to write the numbers.");
    intro.setImgUrl("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_kid1.png?alt=media&token=444efe48-1e17-49bb-bbe1-3c5571a81e58");

    Intro intro1 = new Intro();
    intro1.setTitle("Let's Learn This");
    intro1.setHeader("In this module you will learn how to understand and recognize “how many” in sets of objects. It provides you examples and exercises that will help you count in sets of objects used.");
    intro1.setSubheader("So after learning this module you are expected to:<br/>" +
        "-<i>Understand and recognize how many in sets of objects.<br/>" +
        "-Count the sets of objects in every exercises.<br/>" +
        "-Write how many object in sets.<i>");
    intro1.setImgUrl("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_kid2.png?alt=media&token=0073f6ad-5f38-4b4a-bc0c-d9ff1f095c48");

    Intro intro2 = new Intro();
    intro2.setTitle("A. Let's Try This");
    intro2.setHeader("Start from the rightmost picture. Count each object then select the correct answer.");
    intro2.setImgUrl("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_kid_3.png?alt=media&token=41615cec-c8da-40b4-a43c-6d7a78f3ce21");

    module.addPage(intro);
    module.addPage(intro1);
    module.addPage(intro2);

    //basketball
    Question question = new Question();
    question.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_basketball.png?alt=media&token=0daaaad2-01dc-483d-9981-7a5559ff6f3c");
    question.setCount(4);
    question.setSample(true);

    //gift
    Question question1 = new Question();
    question1.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_gift.png?alt=media&token=171a0754-7c7d-4bfe-8517-c814ede6450e");
    question1.setCount(6);
    question1.setSample(true);

    module.addPage(question);
    module.addPage(question1);

    Intro intro3 = new Intro();
    intro3.setTitle("B. Let's Answer This");
    intro3.setHeader("Choose the number for the indicated set of objects.");
    intro3.setImgUrl("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_kid_3.png?alt=media&token=41615cec-c8da-40b4-a43c-6d7a78f3ce21");
    module.addPage(intro3);

    //cat
    Question question2 = new Question();
    question2.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_cat.png?alt=media&token=4c13847d-0776-400f-b23a-a1876649dbcc");
    question2.setCount(3);
    module.addPage(question2);

    //panther
    Question question3 = new Question();
    question3.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_pink_phanter.png?alt=media&token=e5e65a14-9311-4c3a-98b0-5e870dd1d30c");
    question3.setCount(6);
    module.addPage(question3);

    //pumpkin
    Question question4 = new Question();
    question4.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_pumpkin.png?alt=media&token=e6a380a4-1f62-44ef-9d79-2fea38833fe1");
    question4.setCount(4);
    module.addPage(question4);

    //bat
    Question question5 = new Question();
    question5.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_bat.png?alt=media&token=5522c1cb-f78e-402c-8403-d0b9261d3f27");
    question5.setCount(2);
    module.addPage(question5);

    //ghost
    Question question6 = new Question();
    question6.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_ghost.png?alt=media&token=0dfc33cc-4e8f-449b-9afc-5a91642eb41c");
    question6.setCount(5);
    module.addPage(question6);

    //tree
    Question question7 = new Question();
    question7.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_tree.png?alt=media&token=ae45808c-0bdf-4228-9b51-abf959b37bb4");
    question7.setCount(9);
    module.addPage(question7);

    //butterfly
    Question question8 = new Question();
    question8.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_butterfly.png?alt=media&token=faf272f4-ef60-48ab-9ca7-09c735a328cb");
    question8.setCount(7);
    module.addPage(question8);

    //tulip
    Question question9 = new Question();
    question9.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_tulip.png?alt=media&token=07103a81-854f-4256-ae22-ba8a9ad19ed2");
    question9.setCount(6);
    module.addPage(question9);

    //gift
    Question question10 = new Question();
    question10.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_gift.png?alt=media&token=171a0754-7c7d-4bfe-8517-c814ede6450e");
    question10.setCount(10);
    module.addPage(question10);

    //hat
    Question question11 = new Question();
    question11.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_hat.png?alt=media&token=62500dc7-79e3-427c-a80b-f15127e13496");
    question11.setCount(8);
    module.addPage(question11);

    Intro intro4 = new Intro();
    intro4.setTitle("Let's Study This");
    intro4.setHeader("A set is a group of things.");
    intro4.setSubheader("An <b>empty set</b> has no member in it.");
    intro4.setImgUrl("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_kid1.png?alt=media&token=444efe48-1e17-49bb-bbe1-3c5571a81e58");
    module.addPage(intro4);

    //book
    Question question12 = new Question();
    question12.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_book.png?alt=media&token=66c71554-4e6b-4b26-a3ff-8dfb8a764a24");
    question12.setCount(2);
    module.addPage(question12);

    //chair
    Question question13 = new Question();
    question13.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_chair.png?alt=media&token=77eed179-f31e-4742-8946-f1c76df91d45");
    question13.setCount(4);
    module.addPage(question13);


    //bees
    Question question15 = new Question();
    question15.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_bee.png?alt=media&token=67417e27-59dd-446f-b7b5-7608697b5f9a");
    question15.setCount(7);
    module.addPage(question15);

    //pan
    Question question16 = new Question();
    question16.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_pan.png?alt=media&token=f77b5248-6385-439d-afc5-9293bf067aef");
    question16.setCount(5);
    module.addPage(question16);

    //egg
    Question question17 = new Question();
    question17.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_egg.png?alt=media&token=e287e46c-d532-4f89-aa59-2b345ff42b66");
    question17.setCount(10);
    module.addPage(question17);

    //pencil
    Question question18 = new Question();
    question18.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_pencil.jpg?alt=media&token=852abcf1-7fff-4469-9616-b4e30318ab28");
    question18.setCount(8);
    module.addPage(question18);

    //lizard
    Question question19 = new Question();
    question19.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_lizard.png?alt=media&token=a4aa6ab3-e030-4c84-8a15-775711445c4c");
    question19.setCount(3);
    module.addPage(question19);

    //house
    Question question20 = new Question();
    question20.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_house.png?alt=media&token=414a98a0-bfca-4c69-9eee-a6a6ed30adc6");
    question20.setCount(1);
    module.addPage(question20);

    Intro intro5 = new Intro();
    intro5.setTitle("Let's Do More");
    intro5.setHeader("Count the spots on each picture. Match with the correct answer.");
    intro5.setImgUrl("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_kid_3.png?alt=media&token=41615cec-c8da-40b4-a43c-6d7a78f3ce21");
    module.addPage(intro5);

    //bug 6
    MatchingQuestion matchingQuestion = new MatchingQuestion();
    MatchingImage matchingImage = new MatchingImage();
    matchingImage.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_bug_6.png?alt=media&token=19b2b2c2-297b-4dd6-a1d9-3a271f138c27");
    matchingImage.setAnswer("6");
    MatchingImage matchingImage1 = new MatchingImage();
    matchingImage1.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_bug_2.png?alt=media&token=aa53b5c7-aabe-430a-87df-2fb53bb84d56");
    matchingImage1.setAnswer("2");
    MatchingImage matchingImage2 = new MatchingImage();
    matchingImage2.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_bug_8.png?alt=media&token=8c0fd2aa-f657-448c-b75b-17022111bd42");
    matchingImage2.setAnswer("8");
    MatchingImage matchingImage3 = new MatchingImage();
    matchingImage3.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_bug_3.png?alt=media&token=b595a5dc-d682-42dc-9b23-b7b9a3692259");
    matchingImage3.setAnswer("3");

    matchingQuestion.addMatchingImage(matchingImage);
    matchingQuestion.addMatchingImage(matchingImage1);
    matchingQuestion.addMatchingImage(matchingImage2);
    matchingQuestion.addMatchingImage(matchingImage3);

    matchingQuestion.addChoice("2");
    matchingQuestion.addChoice("3");
    matchingQuestion.addChoice("6");
    matchingQuestion.addChoice("8");

    module.addPage(matchingQuestion);

    Intro intro6 = new Intro();
    intro6.setTitle("Let's Test Ourselves");
    intro6.setHeader("Count the pencils in box. Match with the correct number.");
    intro6.setImgUrl("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_kid1.png?alt=media&token=444efe48-1e17-49bb-bbe1-3c5571a81e58");
    module.addPage(intro6);


    MatchingQuestion matchingQuestion1 = new MatchingQuestion();
    MatchingImage matchingImage0 = new MatchingImage();
    matchingImage0.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_pencil_3.png?alt=media&token=181f62ef-165e-4188-a766-505b163092d3");
    matchingImage0.setAnswer("3");
    MatchingImage matchingImage01 = new MatchingImage();
    matchingImage01.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_pencil_5.png?alt=media&token=d2e2bd0c-c467-4ded-94ad-e420ace2897a");
    matchingImage01.setAnswer("5");
    MatchingImage matchingImage02 = new MatchingImage();
    matchingImage02.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_pencil_4.png?alt=media&token=3cdb5b01-515b-4a8a-9fac-191b7df0a9bd");
    matchingImage02.setAnswer("4");
    MatchingImage matchingImage03 = new MatchingImage();
    matchingImage03.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_pencil_7.png?alt=media&token=b09eab84-71c5-4614-a0cc-58b95ce0440e");
    matchingImage03.setAnswer("7");

    matchingQuestion1.addMatchingImage(matchingImage02);
    matchingQuestion1.addMatchingImage(matchingImage03);
    matchingQuestion1.addMatchingImage(matchingImage01);
    matchingQuestion1.addMatchingImage(matchingImage0);

    matchingQuestion1.addChoice("3");
    matchingQuestion1.addChoice("5");
    matchingQuestion1.addChoice("4");
    matchingQuestion1.addChoice("7");

    module.addPage(matchingQuestion1);

    Intro intro7 = new Intro();
    intro7.setTitle("Let's Do this");
    intro7.setHeader("Count the candles on each cake. Match with the correct number.");
    intro7.setImgUrl("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_kid2.png?alt=media&token=0073f6ad-5f38-4b4a-bc0c-d9ff1f095c48");
    module.addPage(intro7);

    MatchingQuestion matchingQuestion001 = new MatchingQuestion();
    MatchingImage matchingImage00 = new MatchingImage();
    matchingImage00.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_cake_2.png?alt=media&token=2dc41ce0-0f6d-4446-af64-5e41d07c91a0");
    matchingImage00.setAnswer("2");
    MatchingImage matchingImage001 = new MatchingImage();
    matchingImage001.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_cake_4.png?alt=media&token=68025d1f-1a00-4173-a343-96dcfa77ee56");
    matchingImage001.setAnswer("4");
    MatchingImage matchingImage002 = new MatchingImage();
    matchingImage002.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_cake_1.png?alt=media&token=688ba548-75b8-4cce-ba5c-b8310ca54971");
    matchingImage002.setAnswer("1");
    MatchingImage matchingImage003 = new MatchingImage();
    matchingImage003.setImage("https://firebasestorage.googleapis.com/v0/b/learningapp-ea37e.appspot.com/o/assets%2Fimg_cake_3.png?alt=media&token=5052f214-e7bd-4ea0-817d-ed568dabecb4");
    matchingImage003.setAnswer("3");

    matchingQuestion001.addMatchingImage(matchingImage001);
    matchingQuestion001.addMatchingImage(matchingImage002);
    matchingQuestion001.addMatchingImage(matchingImage003);
    matchingQuestion001.addMatchingImage(matchingImage00);

    matchingQuestion001.addChoice("2");
    matchingQuestion001.addChoice("4");
    matchingQuestion001.addChoice("1");
    matchingQuestion001.addChoice("3");

    module.addPage(matchingQuestion001);


    return module;
  }
}
