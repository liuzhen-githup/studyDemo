/**
 * Copyright(c) 2018 asura
 */
package comm.yfn.demo;

import com.alibaba.fastjson.JSON;
import comm.study.bean.TestPics;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 *
 * @Description:
 * @ClassName IOTestPics
 * @Author zhen.liu
 * @Date 2021/8/30 9:44 上午
 * @Version 1.0
 **/
public class IOTestPics {

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        FileInputStream fis=null;
        InputStreamReader isr=null;
        BufferedReader bReader=null;
        OutputStreamWriter osw=null;
        FileOutputStream fos=null;
        BufferedWriter bWriter=null;
        try {
            int rand;
            String line;
            StringBuffer stringBuffer ;
            fis=new FileInputStream("sku.txt");//定义输入文件
            fos=new FileOutputStream("skus.txt");//定义输出文件
            isr=new InputStreamReader(fis);//读取输入文件
            osw=new OutputStreamWriter(fos);//写入输入文件
            bReader=new BufferedReader(isr);//读取缓冲区
            bWriter=new BufferedWriter(osw);//写入缓存区
            while((line=bReader.readLine())!=null){ //按行读取数据
                String aString=line+ ",";//将读取的行数据和字符串数组按要求进行拼接
                System.out.print(aString);//输出拼接结果
                bWriter.write(aString);//将拼结果按行写入出入文件中
            }
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("找不到文件");
        }catch (IOException e) {
            // TODO: handle exception
            System.out.println("读取文件失败");
        }finally{
            try {
                bReader.close();//关闭读取缓冲区
                isr.close();//关闭读取文件内容
                fis.close();//关闭读取文件
                bWriter.close();//关闭写入缓存区
                osw.close();//关闭写入文件内容
                fos.close();//关闭写入文件
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    public static final String OLD_URL_3 = "http://static.selleroa.com/";

    public static final String OLD_URL_4 = "http://static-erp.oss-cn-shenzhen.aliyuncs.com/";

    public static final String OLD_URL_5 = "http://cdn2.selleroa.com/";

    public static final String CDN2_URL = "https://cdn2.selleroa.com/";

    public static final String SPECIAL ="\\?";
    @Test
    public void readFile01() throws IOException {
        FileReader fr= new FileReader("result888.txt");
        FileWriter file2= new FileWriter("result999.txt");
        BufferedReader br=new BufferedReader(fr);
        String line="";
        List<String> codes = productList();
        System.out.println(codes.size());
        while ((line=br.readLine())!=null) {
            TestPics test = JSON.parseObject(line, TestPics.class);
            List<TestPics.Images> pics = test.getPics();
            pics.forEach(pic->{
                pic.setUrl(getNewUrl(pic.getUrl()));
            });
            test.setPics(pics);
            System.out.println(JSON.toJSONString(test));
        }
        br.close();
        fr.close();
    }

    private static List<String> productList(){
        List<String> spuCodes = new ArrayList<>();
        String codes = "\"25189383\",\"89899450\",\"38434704\",\"90731021\",\"41110431\",\"81041278\",\"54350440\",\"95832488\",\"13807766\",\"66186430\",\"74423611\",\"16669721\",\"45622277\",\"68143294\",\"92020149\",\"41604100\",\"92464918\",\"35035470\",\"76645193\",\"68973789\",\"33848680\",\"57891006\",\"96075908\",\"91542317\",\"68536536\",\"24151948\",\"11962993\",\"35635623\",\"80669570\",\"67737211\",\"26517943\",\"64959577\",\"48306242\",\"36659834\",\"80196914\",\"11396464\",\"78634468\",\"29497726\",\"87403977\",\"46748103\",\"63785787\",\"47668535\",\"58374237\",\"17038601\",\"61785927\",\"81576106\",\"32911789\",\"16328832\",\"36652012\",\"88490201\",\"42123410\",\"67697945\",\"35062946\",\"72820005\",\"29993728\",\"83063616\",\"60710308\",\"23477353\",\"42575865\",\"92028477\",\"10353256\",\"22156362\",\"12455872\",\"21418359\",\"35652903\",\"34223413\",\"27158541\",\"70714600\",\"29902414\",\"81378052\",\"42251296\",\"17068279\",\"69290245\",\"66217830\",\"36666820\",\"92806738\",\"62838663\",\"66813043\",\"97539960\",\"10218978\",\"23797447\",\"77775357\",\"62838103\",\"85783964\",\"90729124\",\"81297888\",\"79042434\",\"79944552\",\"24830972\",\"82399087\",\"95322884\",\"71118765\",\"84720529\",\"32671056\",\"48398370\",\"38615863\",\"11325645\",\"88467031\",\"38420611\",\"74520438\",\"24115951\",\"28142472\",\"77757992\",\"87545842\",\"42910424\",\"49434109\",\"20990006\",\"81127572\",\"80712693\",\"72282516\",\"39967654\",\"93398951\",\"51256382\",\"74706752\",\"72540227\",\"97535777\",\"50749468\",\"86566955\",\"42149231\",\"79514397\",\"66998613\",\"48784718\",\"45558562\",\"61482291\",\"47230985\",\"58932980\",\"49151128\",\"26158970\",\"22354936\",\"29199562\",\"10382264\",\"50658699\",\"73389575\",\"43494585\",\"48175512\",\"86348396\",\"13337162\",\"19274705\",\"98538304\",\"23628913\",\"82989897\",\"17274391\",\"28527005\",\"71595809\",\"44435887\",\"27552384\",\"17264414\",\"20789068\",\"32326363\",\"42843097\",\"54354024\",\"49140400\",\"33925018\",\"25198673\",\"85747502\",\"42441128\",\"30283015\",\"83497002\",\"91527101\",\"84709381\",\"24954976\",\"33263396\",\"46812386\",\"19585247\",\"52476228\",\"97474671\",\"19238623\",\"62804255\",\"78158920\",\"51524315\",\"48152568\",\"92935692\",\"16134489\",\"82006328\",\"47039385\",\"93060021\",\"62839817\",\"97951912\",\"40646753\",\"12713963\",\"79711707\",\"31695271\",\"63746952\",\"77139937\",\"13363639\",\"88395054\",\"55535911\",\"77868252\",\"51057994\",\"58976599\",\"39929024\",\"94417596\",\"88948782\",\"85520092\",\"37619564\",\"86511236\",\"46596013\",\"58149806\",\"12529964\",\"82813601\",\"41993803\",\"51878053\",\"60300587\",\"90168378\",\"37130000\",\"64977645\",\"25195436\",\"20576713\",\"96717102\",\"27106923\",\"85438400\",\"17178819\",\"22697130\",\"70418467\",\"99866664\",\"16698581\",\"98847318\",\"92628344\",\"65625198\",\"30981762\",\"56709511\",\"89054621\",\"38827876\",\"86971305\",\"35558052\",\"34526224\",\"16778338\",\"15896248\",\"55155232\",\"95602654\",\"59520519\",\"18463746\",\"43338866\",\"57955457\",\"21811851\",\"55075795\",\"47393401\",\"58796630\",\"23184199\",\"43118046\",\"71316646\",\"16170970\",\"92353127\",\"96662071\",\"43513756\",\"27051307\",\"68085992\",\"20269250\",\"16973028\",\"19548487\",\"49094248\",\"18730160\",\"25874359\",\"64031345\",\"29344990\",\"59956975\",\"59034605\",\"59209533\",\"49852945\",\"97960992\",\"67454179\",\"42421462\",\"47235702\",\"57754365\",\"26155801\",\"32344487\",\"84850536\",\"16957393\",\"56058138\",\"87129295\",\"63965999\",\"14590883\",\"55159921\",\"81045088\",\"73075946\",\"28218154\",\"52092884\",\"73443177\",\"81791948\",\"69556090\",\"68720915\",\"55105363\",\"22688986\",\"17399512\",\"60018976\",\"50758715\",\"40869212\",\"27419446\",\"71625131\",\"34170840\",\"82683405\",\"12989072\",\"96401954\",\"76815474\",\"58936592\",\"71323922\",\"69761818\",\"31605442\",\"13884578\",\"50333432\",\"56982074\",\"11459329\",\"56664366\",\"65456039\",\"49597365\",\"18058399\"";
        String[] split = codes.split(",");
        for (int i = 0; i < split.length; i++) {
            spuCodes.add(split[i].replace("\"",""));
        }
        return spuCodes;
    }


    private static final List<String> errorUrl = new ArrayList<>();
    static {
        errorUrl.add(OLD_URL_3);
        errorUrl.add(OLD_URL_4);
        errorUrl.add(OLD_URL_5);
    }

    public static String getNewUrl(String oldUrl){
        if(oldUrl == null){
            return null;
        }
        for (String url: errorUrl) {
            if(oldUrl.contains(url)){
                return oldUrl.replaceAll(url, CDN2_URL).split(SPECIAL)[0];
            }
        }
        return oldUrl;
    }
}
