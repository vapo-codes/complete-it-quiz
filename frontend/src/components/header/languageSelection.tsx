import {
  IconButton,
  Menu,
  MenuButton,
  MenuItem,
  MenuList,
} from "@chakra-ui/react";
import { Icon } from "@iconify/react";
import { useState } from "react";
import { useTranslation } from "react-i18next";

// ############# Test data #############
const languages = {
  Magyar: "hu",
  English: "en",
  Deutsch: "de",
};
// ####################################

const LanguageSelection = () => {
  const [selected, setSelected] = useState<string>("");

  const { i18n } = useTranslation();

  return (
    <Menu>
      <MenuButton
        as={IconButton}
        aria-label="Options"
        icon={<Icon icon="mdi:translate" />}
        variant="outline"
      />
      <MenuList>
        {Object.keys(languages).map((languageKey) => (
          <MenuItem
            key={languageKey}
            value={languages[languageKey as keyof typeof languages]}
            onClick={() => {
              setSelected(languages[languageKey as keyof typeof languages]);
              i18n.changeLanguage(
                languages[languageKey as keyof typeof languages]
              );
            }}
          >
            {languageKey}
          </MenuItem>
        ))}
      </MenuList>
    </Menu>
  );
};

export default LanguageSelection;
