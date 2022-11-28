package service.conta;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ParametrosConta {
    final static BigDecimal TX_RENDIMENTO_CI_PF = new BigDecimal("1.5").setScale(4, RoundingMode.HALF_EVEN);
    final static BigDecimal TX_RENDIMENTO_CI_PJ = new BigDecimal("3.5").setScale(4, RoundingMode.HALF_EVEN);
    final static BigDecimal TX_RENDIMENTO_CP_PF = new BigDecimal("1.0").setScale(4, RoundingMode.HALF_EVEN);
    final static BigDecimal TX_TRANSACAO_PF = new BigDecimal("0.0").setScale(4, RoundingMode.HALF_EVEN);
    final static BigDecimal TX_TRANSACAO_PJ = new BigDecimal("0.5").setScale(4, RoundingMode.HALF_EVEN);
}
