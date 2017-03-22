import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Created by Ilgiz on 23.10.2016.
 */
public class GetSender {
    static CloseableHttpClient httpclient = HttpClients.createDefault();

    public static void main(String[] args) {
        double x = 0.01;
        int degree = 90;
        String begin = "http://192.168.1.11:3000/tool_update?id=39&rot_x=";
        String end = "&rot_y=6&rot_z=&pos_x=&pos_y=&pos_z=&commit=Update+Tool";
        StringBuilder url = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 100; j++) {
                url.append(begin);
                url.append(degree);
                url.append(end);
                try {
                    senGet(url.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (j % 2 == 0)
                    degree--;
            }
            degree++;
            for (int j = 0; j < 100; j++) {
                url.append(begin);
                url.append(degree);
                url.append(end);
                try {
                    senGet(url.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (j % 2 == 0)
                    degree++;
            }
        }
    }

    private static void senGet(String url) throws Exception {

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response1 = httpclient.execute(httpGet);

        try {
            System.out.println(response1.getStatusLine());
//            HttpEntity entity1 = response1.getEntity();
//
//            EntityUtils.consume(entity1);
        } finally {
            response1.close();
        }

    }

}
