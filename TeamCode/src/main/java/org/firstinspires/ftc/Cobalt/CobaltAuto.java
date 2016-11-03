package org.firstinspires.ftc.Cobalt;

import android.widget.Switch;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannelController;

/**
 * Created by Kilroy Programming on 10/18/2016.
 */
@Autonomous(name="CobaltAuto", group="Cobalt")
public class CobaltAuto extends OpMode
{
    /* Declare OpMode members. */
    HardwareCobalt robot       = new HardwareCobalt(); // use the class created to define a Pushbot's hardware

    public enum controlState
    {
        STATE_ONE, STATE_TWO
    }


    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Yell at the robot to win harder");    //
        updateTelemetry(telemetry);
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop()
    {

    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start()
    {
        robot.leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.leftRearMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightRearMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        HardwareCobalt.cdim.setDigitalChannelMode(HardwareCobalt.GROUND_LED_PORT,DigitalChannelController.Mode.OUTPUT);




    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop()
    {

        robot.rightRearMotor.setPower(1.0);
        robot.rightFrontMotor.setPower(1.0);

        controlState AutoOp = controlState.STATE_ONE;

//will this work? probably not
        // RR = rightRear
          // RF = rightFront
          // LR = leftRear
          // LF = leftFront


        int setTargetPositionRR = 360;
        int setTargetPositionFR = 360;
        int setTargetPositionLR = 360;
        int setTargetPositionLF = 360;

        robot.rightRearMotor.setTargetPosition(setTargetPositionRR);
        robot.rightFrontMotor.setTargetPosition(setTargetPositionFR);
        robot.leftRearMotor.setTargetPosition(setTargetPositionLR);
        robot.leftFrontMotor.setTargetPosition(setTargetPositionLF);

        int getTargetPositionRR = robot.rightRearMotor.getTargetPosition();
        int getTargetPositionFR = robot.rightFrontMotor.getTargetPosition();
        int getTargetPositionLR = robot.leftRearMotor.getTargetPosition();
        int getTargetPositionLF = robot.leftFrontMotor.getTargetPosition();

        int getCurrentPositionRR = robot.rightRearMotor.getCurrentPosition();
        int getCurrentPositionFR = robot.rightFrontMotor.getCurrentPosition();
        int getCurrentPositionLR = robot.leftRearMotor.getCurrentPosition();
        int getCurrentPositionLF = robot.leftFrontMotor.getCurrentPosition();










                  while (getCurrentPositionRR < 360 & getCurrentPositionFR < 360 & getCurrentPositionLR < 360 & getCurrentPositionLF < 360) {
                     robot.leftRearMotor.setPower(1.0);
                     robot.leftFrontMotor.setPower(1.0);
                     robot.rightRearMotor.setPower(1.0);
                     robot.rightFrontMotor.setPower(1.0);

                       getCurrentPositionRR = robot.rightRearMotor.getCurrentPosition();
                       getCurrentPositionFR = robot.rightFrontMotor.getCurrentPosition();
                       getCurrentPositionLR = robot.leftRearMotor.getCurrentPosition();
                       getCurrentPositionLF = robot.leftFrontMotor.getCurrentPosition();
                 }



        }





    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {

    }
// Motor us encoders!

}

