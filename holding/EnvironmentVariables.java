package holding;

/**
 * RUN:
 *         javac holding/EnvironmentVariables.java && java holding.EnvironmentVariables
 * OUTPUT:
 *         USERPROFILE: C:\Documents and Settings\└фьшэшёЄЁрЄюЁ
 *         PATHEXT: .COM;.EXE;.BAT;.CMD;.VBS;.VBE;.JS;.JSE;.WSF;.WSH
 *         COMMANDER_INI: C:\Documents and Settings\└фьшэшёЄЁрЄюЁ\Application Data\GHISLER\wincmd.ini
 *         =ExitCode: 00000000
 *         TEMP: C:\DOCUME~1\9335~1\LOCALS~1\Temp
 *         SystemDrive: C:
 *         ProgramFiles: C:\Program Files
 *         Path: D:\Python33\;D:\oraclexe\app\oracle\product\11.2.0\server\bin;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\Program Files\TortoiseSVN\bin;D:\php5.4.22;C:\Program Files\Git\cmd;c:\Program Files\Java\jdk1.7.0_45\bin;D:\TortoiseGit\bin
 *         HOMEDRIVE: C:
 *         PROCESSOR_REVISION: 2a07
 *         USERDOMAIN: WIN2003R2
 *         ALLUSERSPROFILE: C:\Documents and Settings\All Users
 *         PROCESSOR_IDENTIFIER: x86 Family 6 Model 42 Stepping 7, GenuineIntel
 *         COMMANDER_PATH: D:\totalcmd
 *         COMMANDER_EXE: D:\totalcmd\TOTALCMD.EXE
 *         COMMANDER_DRIVE: D:
 *         SESSIONNAME: Console
 *         TMP: C:\DOCUME~1\9335~1\LOCALS~1\Temp
 *         CommonProgramFiles: C:\Program Files\Common Files
 *         LOGONSERVER: \\WIN2003R2
 *         PROCESSOR_ARCHITECTURE: x86
 *         FP_NO_HOST_CHECK: NO
 *         OS: Windows_NT
 *         HOMEPATH: \Documents and Settings\└фьшэшёЄЁрЄюЁ
 *         PROMPT: $P$G
 *         PROCESSOR_LEVEL: 6
 *         =D:: D:\univer\java\thinking_in_java
 *         ClusterLog: C:\WINDOWS\Cluster\cluster.log
 *         COMPUTERNAME: WIN2003R2
 *         windir: C:\WINDOWS
 *         SystemRoot: C:\WINDOWS
 *         NUMBER_OF_PROCESSORS: 4
 *         USERNAME: └фьшэшёЄЁрЄюЁ
 *         ComSpec: C:\WINDOWS\system32\cmd.exe
 *         APPDATA: C:\Documents and Settings\└фьшэшёЄЁрЄюЁ\Application Data
 */

import java.util.*;

public class EnvironmentVariables {

    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}