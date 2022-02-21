package com.test;

import java.util.List;

import com.test.multi.ac.AcRobot;
import com.test.multi.ac.AcRobot.AcResult;
import com.test.multi.trie.Trie;

import junit.framework.TestCase;

/**
 * 多模式，字符串匹配
 * 多模式：在多个模式串和一个主串之间做匹配
 * @author YLine
 *
 * 2019年4月8日 下午5:17:23
 */
public class MultiSample extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testTrie()
    {
        System.out.println("-------------testTrie--------------");
        
        Trie trie = new Trie();
        trie.insert("how");
        trie.insert("hi");
        trie.insert("her");
        trie.insert("hello");
        trie.insert("so");
        trie.insert("see");
        
        assertEquals(false, trie.find(""));
        assertEquals(false, trie.find("h"));
        assertEquals(false, trie.find("ho"));
        assertEquals(false, trie.find("hio"));
        assertEquals(false, trie.find("hoq"));
        
        assertEquals(true, trie.find("how"));
        assertEquals(true, trie.find("hi"));
        assertEquals(true, trie.find("her"));
        assertEquals(true, trie.find("hello"));
        assertEquals(true, trie.find("so"));
        assertEquals(true, trie.find("see"));
    }
    
    public void testAc()
    {
        System.out.println("-------------testAc--------------");
        
        // 构建，暂时不做删除
        AcRobot robot = new AcRobot();
        robot.insert("c");
        robot.insert("bc");
        robot.insert("bcd");
        robot.insert("abcd");
        
        // 构建failed指针，正式建立成Ac自动机
        robot.buildFailurePointer();
        
        robot.logAcNode();
        
        // 查找对应的值
        assertAcSolution(robot, "abcd", 1);
        assertAcSolution(robot, "fdafdsafdsafdsafdsa", 0);
        assertAcSolution(robot, "abcdc", 2);
        assertAcSolution(robot, "abcdd", 1);
        assertAcSolution(robot, "abcdbcd", 2);
        assertAcSolution(robot, CHAPTER_WAR_PEACE, 90);
    }
    
    public void assertAcSolution(AcRobot robot, String mainStr, int size)
    {
        List<AcResult> result = robot.find(mainStr);
        assertEquals(size, result.size());
        
        System.out.println("\n------------------------str = " + mainStr + ", size = " + result.size()
            + "---------------");
        for (int i = 0; i < result.size(); i++)
        {
            String info = String.format("i: %s, result:{%s}", String.valueOf(i), result.get(i).toString());
            System.out.println(info);
        }
    }
    
    // 文章
    private final String CHAPTER_WAR_PEACE =
        "“WELL, PRINCE, Genoa and Lucca are now no more than private estates of the Bonaparte family. No, I warn you, that if you do not tell me we are at war, if you again allow yourself to palliate all the infamies and atrocities of this Antichrist (upon my word, I believe he is), I don't know you in future, you are no longer my friend, no longer my faithful slave, as you say. There, how do you do, how do you do? I see I'm scaring you, sit down and talk to me.”\r\n"
            +
        "\r\n" +
            "These words were abcd uttered in July 1805 by Anna Pavlovna Scherer, a distinguished lady of the court, and confidential maid-of-honour to the Empress Marya Fyodorovna. It was her greeting to Prince Vassily, a man high in rank and office, who was the first to arrive at her soirée. Anna Pavlovna had been coughing for the last few days; she had an attack of la grippe, as she said—grippe was then a new word only used by a few people. In the notes she had sent round in the morning by a footman in red livery, she had written to all indiscriminately:\r\n"
            +
        "\r\n" +
        "“If you have nothing better to do, count (or prince), and if the prospect of spending an evening with a poor invalid is not too alarming to you, I shall be charmed to see you at my house between 7 and 10. Annette Scherer.”\r\n" +
        "\r\n" +
            "“Heavens! what a bc violent outburst!” the prince responded, not in the least disconcerted at such a reception. He was wearing an embroidered court uniform, stockings and slippers, and had stars on his breast, and a bright smile on his flat face.\r\n"
            +
        "\r\n" +
        "He spoke in that elaborately choice French, in which our forefathers not only spoke but thought, and with those slow, patronising intonations peculiar to a man of importance who has grown old in court society. He went up to Anna Pavlovna, kissed her hand, presenting her with a view of his perfumed, shining bald head, and complacently settled himself on the sofa.\r\n" +
        "\r\n" +
            "“First of all, tell bcd me how you are, dear friend. Relieve a friend's anxiety,” he said, with no change of his voice and tone, in which indifference, and even irony, was perceptible through the veil of courtesy and sympathy.\r\n"
            +
        "\r\n" +
        "“How can one be well when one is in moral suffering? How can one help being worried in these times, if one has any feeling?” said Anna Pavlovna. “You'll spend the whole evening with me, I hope?”\r\n" +
        "\r\n" +
        "“And the fête at the English ambassador's? To-day is Wednesday. I must put in an appearance there,” said the prince. “My daughter is coming to fetch me and take me there.”\r\n" +
        "\r\n" +
        "“I thought to-day's fête had been put off. I confess that all these festivities and fireworks are beginning to pall.”\r\n" +
        "\r\n" +
        "“If they had known that it was your wish, the fête would have been put off,” said the prince, from habit, like a wound-up clock, saying things he did not even wish to be believed.\r\n" +
        "\r\n" +
        "“Don't tease me. Well, what has been decided in regard to the Novosiltsov dispatch? You know everything.”\r\n" +
        "\r\n" +
        "“What is there to tell?” said the prince in a tired, listless tone. “What has been decided? It has been decided that Bonaparte has burnt his ships, and I think that we are about to burn ours.”\r\n" +
        "\r\n" +
        "Prince Vassily always spoke languidly, like an actor repeating his part in an old play. Anna Pavlovna Scherer, in spite of her forty years, was on the contrary brimming over with excitement and impulsiveness. To be enthusiastic had become her pose in society, and at times even when she had, indeed, no inclination to be so, she was enthusiastic so as not to disappoint the expectations of those who knew her. The affected smile which played continually about Anna Pavlovna's face, out of keeping as it was with her faded looks, expressed a spoilt child's continual consciousness of a charming failing of which she had neither the wish nor the power to correct herself, which, indeed, she saw no need to correct.\r\n" +
        "\r\n" +
        "In the midst of a conversation about politics, Anna Pavlovna became greatly excited.";
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
