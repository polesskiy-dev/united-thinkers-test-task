package response_code_tests;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import unipay.request.SaleRequest;
import unipay.request.ResponseCodeWithAccountDataRequest;
import unipay.request.parts.AuthInfo;
import unipay.request.parts.TransactionInfo;
import unipay.request.parts.account.AccountData;
import unipay.request.parts.account.AccountInfo;
import utils.HttpRequest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ResponseCodeTrackDataD05 {
    private static final String EXPECTED_RESPONSE_CODE_STRING = "responseCode=D05";

    private int amount;
    private SaleRequest saleRequest;

    public ResponseCodeTrackDataD05(int amount) {
        this.amount = amount;
        this.saleRequest = new ResponseCodeWithAccountDataRequest(
                new AuthInfo("sale", "test_api_user", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1", "2001"),
                new AccountInfo("R"),
                new TransactionInfo(this.amount, "RE"),
                new AccountData("(~2001)021301000F3D0000%*4111********1111^SMITH/JOHN^*****************************?*DFE3DC12146B65176C8E7C61763993837DEDB90E67FB89DF644CF3E8C90FABEC3296D22063C28A269A557FA77680D9615A74AC726E6786C4CE4E7AC8C3A44F0861F566A0C3DAD0F9DB388549F87B303DDB1EBBD03D3E6FCD99E511FA629949003A0002E000E25C6203")
        );
    }

    @Test
    public void testCreateTestDataSuite() {
        try {
            String REQUEST_URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl?" + this.saleRequest.toGetParamsString();
            String response = HttpRequest.sendGet(REQUEST_URL);


            System.out.printf("Send sale request with accountNumber and amount %d to URL:\r\n%s\r\nResponse: %s\r\n", this.amount, REQUEST_URL, response);
            assertTrue("Expect "+EXPECTED_RESPONSE_CODE_STRING, response.contains(EXPECTED_RESPONSE_CODE_STRING));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {7000}, {7500}, {7999},
        });
    }
}
