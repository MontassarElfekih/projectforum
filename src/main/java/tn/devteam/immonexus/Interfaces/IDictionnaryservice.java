package tn.devteam.immonexus.Interfaces;

import tn.devteam.immonexus.Entities.Dictionary;

public interface IDictionnaryservice {
    public Dictionary AddWord(Long idWord , Long idUser);

    public Dictionary findAllWords();
}
