/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class pjmedia_tone_digit {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected pjmedia_tone_digit(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(pjmedia_tone_digit obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_pjmedia_tone_digit(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setDigit(char value) {
    pjsua2JNI.pjmedia_tone_digit_digit_set(swigCPtr, this, value);
  }

  public char getDigit() {
    return pjsua2JNI.pjmedia_tone_digit_digit_get(swigCPtr, this);
  }

  public void setOn_msec(short value) {
    pjsua2JNI.pjmedia_tone_digit_on_msec_set(swigCPtr, this, value);
  }

  public short getOn_msec() {
    return pjsua2JNI.pjmedia_tone_digit_on_msec_get(swigCPtr, this);
  }

  public void setOff_msec(short value) {
    pjsua2JNI.pjmedia_tone_digit_off_msec_set(swigCPtr, this, value);
  }

  public short getOff_msec() {
    return pjsua2JNI.pjmedia_tone_digit_off_msec_get(swigCPtr, this);
  }

  public void setVolume(short value) {
    pjsua2JNI.pjmedia_tone_digit_volume_set(swigCPtr, this, value);
  }

  public short getVolume() {
    return pjsua2JNI.pjmedia_tone_digit_volume_get(swigCPtr, this);
  }

  public pjmedia_tone_digit() {
    this(pjsua2JNI.new_pjmedia_tone_digit(), true);
  }

}
