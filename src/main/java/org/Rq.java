package org;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rq {
    private String actionName;
    private int id;

    public Rq(String cmd){
        String[] cmdBits = cmd.split(" ");

        actionName = cmdBits[0];
        id = cmdBits.length > 1 ? Integer.parseInt(cmdBits[1]) : -1;
    }
}
