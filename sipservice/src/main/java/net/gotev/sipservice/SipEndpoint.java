package net.gotev.sipservice;

import org.pjsip.pjsua2.Endpoint;
import org.pjsip.pjsua2.OnIpChangeProgressParam;
import org.pjsip.pjsua2.OnTransportStateParam;
import org.pjsip.pjsua2.pj_constants_;
import org.pjsip.pjsua2.pjsip_transport_state;
import org.pjsip.pjsua2.pjsua_ip_change_op;

public class SipEndpoint extends Endpoint {
    private final SipService service;

    public SipEndpoint(SipService service) {
        super();
        this.service = service;
    }

    @Override
    public void onTransportState(OnTransportStateParam prm) {
        super.onTransportState(prm);
        if (prm.getState() == pjsip_transport_state.PJSIP_TP_STATE_DISCONNECTED &&
                prm.getLastError() == SipServiceConstants.PJSIP_TLS_ECERTVERIF) {
            service.getBroadcastEmitter().notifyTlsVerifyStatusFailed();
            service.stopSelf();
        }

    }

    @Override
    public void onIpChangeProgress(OnIpChangeProgressParam prm) {
        super.onIpChangeProgress(prm);
        if (prm.getStatus() != pj_constants_.PJ_SUCCESS) {
            hangupAllCalls();
            service.getBroadcastEmitter().callReconnectionState(CallReconnectionState.FAILED);
            return;
        }

        if (prm.getOp() == pjsua_ip_change_op.PJSUA_IP_CHANGE_OP_COMPLETED) {
            service.getBroadcastEmitter().callReconnectionState(CallReconnectionState.SUCCESS);
        }
    }
}
