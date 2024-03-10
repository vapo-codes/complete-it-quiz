import { Box } from "@chakra-ui/react";
import LanguageSelection from "./languageSelection";
import { ColorModeSwitcher } from "../../ColorModeSwitcher";

const HeaderComponent = () => {
  return (
    <Box display="flex" flexDirection="row" justifyContent="flex-end">
      <LanguageSelection />
      <ColorModeSwitcher justifySelf="flex-end" />
    </Box>
  );
};

export default HeaderComponent;
