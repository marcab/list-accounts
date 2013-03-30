package com.example.listaccounts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ListAccountsActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the accounts
        Account[] accounts = AccountManager.get(this).getAccounts();

        // Format for display
        String[] displayStrings = new String[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            Account account = accounts[i];
            displayStrings[i] = String.format("%s\n(%s)", account.name,
                    account.type);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, displayStrings);

        setListAdapter(adapter);
    }

}
